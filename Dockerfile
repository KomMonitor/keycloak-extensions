ARG KC_IMAGE_VERSION="26.4.7"
ARG KC_LIB_VERSION="26.4.7"

FROM maven:3-eclipse-temurin-17-alpine AS mvnbuilder

# Copy sourcecode and compile
COPY src src
COPY pom.xml pom.xml
RUN mvn clean package

FROM quay.io/keycloak/keycloak:${KC_IMAGE_VERSION} AS kcbuilder
COPY --from=mvnbuilder /target/keycloak-extensions-1.0.jar /opt/keycloak/providers/keycloak-extensions-1.0.jar

# build for postgres
WORKDIR /opt/keycloak-postgres
ENV KC_DB=postgres
RUN cp -r /opt/keycloak/* .
RUN ls -lhat
RUN ./bin/kc.sh build --features="admin-fine-grained-authz:v1,scripts,token-exchange:v1,"

# build for mssql
WORKDIR /opt/keycloak-mssql
ENV KC_DB=mssql
RUN cp -r /opt/keycloak/* .
RUN ./bin/kc.sh build --features="admin-fine-grained-authz:v1,scripts,token-exchange:v1,"

# target = postgres
FROM quay.io/keycloak/keycloak:${KC_IMAGE_VERSION} AS postgres
COPY --from=kcbuilder /opt/keycloak-postgres/ /opt/keycloak/
ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "start", "--optimized"]

# target = mssql
FROM quay.io/keycloak/keycloak:${KC_IMAGE_VERSION} AS mssql
COPY --from=kcbuilder /opt/keycloak-mssql/ /opt/keycloak/
ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "start", "--optimized"]