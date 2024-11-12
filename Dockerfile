ARG KC_IMAGE_VERSION="25.0.6"
ARG KC_LIB_VERSION="25.0.6"

FROM maven:3-eclipse-temurin-17-alpine  AS mvnbuilder

# Copy sourcecode and compile
COPY src src
COPY pom.xml pom.xml
RUN mvn clean package

FROM quay.io/keycloak/keycloak:${KC_IMAGE_VERSION} AS kcbuilder

# Configure a database vendor
ENV KC_DB=postgres

WORKDIR /opt/keycloak
COPY --from=mvnbuilder /target/keycloak-extensions-1.0.jar /opt/keycloak/providers/keycloak-extensions-1.0.jar
RUN /opt/keycloak/bin/kc.sh build --features="admin-fine-grained-authz,scripts"

FROM quay.io/keycloak/keycloak:latest AS final
COPY --from=kcbuilder /opt/keycloak/ /opt/keycloak/

ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "start", "--optimized"]