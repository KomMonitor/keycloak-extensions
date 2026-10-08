# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [26.7.4]
> 22 Sep 2026

### Updated

- Raise Keycloak patch version ([2c3434c](https://github.com/KomMonitor/keycloak-extensions/commit/2c3434c6b7e45247fc5ba5d79383ad29e2cd898f))

## [26.7.3]
> 11 Sep 2026

### Changed

- Bump github/codeql-action/upload-sarif from 4.37.3 to 4.37.9 ([1bd704a](https://github.com/KomMonitor/keycloak-extensions/commit/1bd704adbd81634e6a7654eb5378f5d983e076b2))
- Merge pull request #24 from KomMonitor/dependabot/github_actions/github/codeql-action/upload-sarif-4.37.9 ([58ea945](https://github.com/KomMonitor/keycloak-extensions/commit/58ea94525d0c24493e47633a365adbab92b513ee))
- Bump docker/login-action from 4.4.0 to 4.6.0 ([301e466](https://github.com/KomMonitor/keycloak-extensions/commit/301e4666449bc05e8e77a10daec77d882d2de2e2))
- Merge pull request #15 from KomMonitor/dependabot/github_actions/docker/login-action-4.6.0 ([b8a99d6](https://github.com/KomMonitor/keycloak-extensions/commit/b8a99d61b1e2f60b28f53b96e0d2a074de8e992e))
- Bump docker/setup-buildx-action from 4.2.0 to 4.3.0 ([828e7b9](https://github.com/KomMonitor/keycloak-extensions/commit/828e7b9d1d6261400c07efc445298fb27c30a885))
- Merge pull request #22 from KomMonitor/dependabot/github_actions/docker/setup-buildx-action-4.3.0 ([d4c3d24](https://github.com/KomMonitor/keycloak-extensions/commit/d4c3d24df65f56a28965c13463d58b60960090e0))

### Removed

- Remove trivy gate ([f1f6f48](https://github.com/KomMonitor/keycloak-extensions/commit/f1f6f480d394ec0c7bb9c8e28c185b558f7efbf1))

### Updated

- Raise Keycloak patch version ([d228caa](https://github.com/KomMonitor/keycloak-extensions/commit/d228caacb5b5056cc0cf53ccc9a73db5100b76be))

## [26.7.2]
> 31 Aug 2026

### Changed

- Update SECURITY.md ([934c19a](https://github.com/KomMonitor/keycloak-extensions/commit/934c19aa865a174826672d2552774b2d4cf452f7))
- Bump sigstore/cosign-installer from 3.9.1 to 4.1.2 ([1500985](https://github.com/KomMonitor/keycloak-extensions/commit/15009859b3abde6940fc13f9529810a7f74645e8))
- Merge pull request #5 from KomMonitor/dependabot/github_actions/sigstore/cosign-installer-4.1.2 ([2b34a5d](https://github.com/KomMonitor/keycloak-extensions/commit/2b34a5dedeacb550b338887a4a21bf0dfd1b30d4))
- Bump org.jboss.logging:jboss-logging from 3.6.0.Final to 3.6.3.Final ([3501565](https://github.com/KomMonitor/keycloak-extensions/commit/3501565005b05ff86a3a4c1091587bcd10c3ca71))
- Merge pull request #7 from KomMonitor/dependabot/maven/org.jboss.logging-jboss-logging-3.6.3.Final ([320e948](https://github.com/KomMonitor/keycloak-extensions/commit/320e948ab3e8be568d3fa7af76e655656262af5e))
- Bump docker/login-action from 3.7.0 to 4.4.0 ([0a364d6](https://github.com/KomMonitor/keycloak-extensions/commit/0a364d619a87350501fcb657b28f7efa08bb4c82))
- Merge pull request #6 from KomMonitor/dependabot/github_actions/docker/login-action-4.4.0 ([c914ec3](https://github.com/KomMonitor/keycloak-extensions/commit/c914ec3517350c15e5c3538af2bd4d3852042a92))
- Bump docker/metadata-action from 5.10.0 to 6.2.0 ([cb8c679](https://github.com/KomMonitor/keycloak-extensions/commit/cb8c679340eb1f2fc8a27d4aee35c54618c07e0a))
- Merge pull request #8 from KomMonitor/dependabot/github_actions/docker/metadata-action-6.2.0 ([73e3dca](https://github.com/KomMonitor/keycloak-extensions/commit/73e3dca196dd03b9e6144d13040b285a3078c2e5))
- Bump docker/build-push-action from 6.19.2 to 7.3.0 ([1a4b923](https://github.com/KomMonitor/keycloak-extensions/commit/1a4b923be83d1646a0bb5ed29079b902f12a3409))
- Merge pull request #11 from KomMonitor/dependabot/github_actions/docker/build-push-action-7.3.0 ([c4c7048](https://github.com/KomMonitor/keycloak-extensions/commit/c4c7048a796636d290345f944559d3d9284374e6))
- Bump docker/setup-buildx-action from 3.12.0 to 4.2.0 ([cdd67e1](https://github.com/KomMonitor/keycloak-extensions/commit/cdd67e177b59343628b9ef26437b2a564224c935))
- Merge pull request #12 from KomMonitor/dependabot/github_actions/docker/setup-buildx-action-4.2.0 ([227129e](https://github.com/KomMonitor/keycloak-extensions/commit/227129e202f249a2286c3100c3629663dd1a675b))
- Bump actions/checkout from 4.3.1 to 7.0.1 ([92666bb](https://github.com/KomMonitor/keycloak-extensions/commit/92666bb77ace4af87d55a7f69cba9e9a37d1f737))
- Merge pull request #13 from KomMonitor/dependabot/github_actions/actions/checkout-7.0.1 ([575cd52](https://github.com/KomMonitor/keycloak-extensions/commit/575cd5232fed23ccb91a21317bb80d155e28dd11))
- Bump github/codeql-action/upload-sarif from 3.36.3 to 4.37.3 ([014aa0b](https://github.com/KomMonitor/keycloak-extensions/commit/014aa0b117b4a28efea5dbad289eb04034ab5168))
- Merge pull request #14 from KomMonitor/dependabot/github_actions/github/codeql-action/upload-sarif-4.37.3 ([85a8a3f](https://github.com/KomMonitor/keycloak-extensions/commit/85a8a3fe9e19c4c85b4140a97b8be1d9b29d8efa))
- Bump maven ([e2e9b62](https://github.com/KomMonitor/keycloak-extensions/commit/e2e9b62382ca268b01db1d1749b61e8b63f07b90))
- Merge pull request #4 from KomMonitor/dependabot/docker/maven-3-eclipse-temurin-26-alpine ([9509d4f](https://github.com/KomMonitor/keycloak-extensions/commit/9509d4f51b93167b8ad0cf462a8d9fa87a74840a))
- Update CHANGELOG ([e7196b7](https://github.com/KomMonitor/keycloak-extensions/commit/e7196b71809f80bdb372738dfad3afb6436dbb11))
- Merge branch 'develop' ([5454265](https://github.com/KomMonitor/keycloak-extensions/commit/54542659a83b00c1f382330295b3f3363f7500fd))

### Updated

- Raise Keycloak version ([1e0c746](https://github.com/KomMonitor/keycloak-extensions/commit/1e0c746aaec650560b8726bf84ffdd06ed246edd))

## [26.7.0]
> 16 Jul 2026

### Added

- Add dependabot config ([d3cf415](https://github.com/KomMonitor/keycloak-extensions/commit/d3cf4151adbe3a3e14d242f524024f0ff1ae7064))
- Add security documentation ([b626c33](https://github.com/KomMonitor/keycloak-extensions/commit/b626c33117981a29a231a987c786737b417120d9))
- Add cliff config and init CHANGELOG ([1621285](https://github.com/KomMonitor/keycloak-extensions/commit/1621285eb1def15817b252df74b0992909e08752))

### Changed

- Update CHANGELOG ([03f41a1](https://github.com/KomMonitor/keycloak-extensions/commit/03f41a185cc67a77b3e1fc55ee570309907eb26d))

### Updated

- Raise Keycloak minor version ([b7af4f7](https://github.com/KomMonitor/keycloak-extensions/commit/b7af4f75879338b735c6d5ad5cd882caff1a6d69))

## [26.6.4]
> 16 Jul 2026

### Changed

- Adjust build workflow to support SNAPSHOT builds ([60d5bca](https://github.com/KomMonitor/keycloak-extensions/commit/60d5bcab2550c842274ae16cacfb2e7c8e3ab40e))

### Updated

- Raise Keycloak hotfix version ([56ddb01](https://github.com/KomMonitor/keycloak-extensions/commit/56ddb01269dcc059d70585bcf10a1fbbb2f7574d))

## [26.6.3]
> 13 Jul 2026

### Changed

- Harden image and enhance CI by security scans and image signing ([74da5e0](https://github.com/KomMonitor/keycloak-extensions/commit/74da5e0cccaa6e17c3f0d1ee6cc577e9850b4e10))
- Restructure CI pipeline so that images with CRITICAL vulnerabilities are not built ([227128c](https://github.com/KomMonitor/keycloak-extensions/commit/227128c2cd5e83c252ceafa63f6736d98dd1cc2b))

### Removed

- Remove unnecessary dummy certs ([e777e76](https://github.com/KomMonitor/keycloak-extensions/commit/e777e766c71ce180f6f5d250c45e4d10ce3d1b54))

### Updated

- Raise Keycloak version ([1cf9528](https://github.com/KomMonitor/keycloak-extensions/commit/1cf952863ecfbddad9c936af3f154ec5d85e90b0))

## [26.5.7]
> 17 Apr 2026

### Updated

- Raise hotfix version ([3c730ae](https://github.com/KomMonitor/keycloak-extensions/commit/3c730aeccae81368b4e71a29b245d61aae5a8b54))

## [26.5.5]
> 12 Mar 2026

### Updated

- Raise Keycloak minor version ([c50527b](https://github.com/KomMonitor/keycloak-extensions/commit/c50527b26054dd6a8b97877cfef0fd8bdf118c36))

## [26.4.7]
> 13 Jan 2026

### Updated

- Raise Keycloak minor version ([534e6d6](https://github.com/KomMonitor/keycloak-extensions/commit/534e6d67cc20616bd61c31916bf08efdcefd5ab4))

## [26.3.4]
> 18 Sep 2025

### Updated

- Raise hotfix version ([9d3508c](https://github.com/KomMonitor/keycloak-extensions/commit/9d3508c872b4c89418db6cf2c42dd8fba4d1bec4))

## [26.3.1]
> 14 Jul 2025

### Updated

- Raise minor version ([a0c5d2d](https://github.com/KomMonitor/keycloak-extensions/commit/a0c5d2d137670918bbe0a655ce1882f12a1d0dc4))

## [26.2.5]
> 11 Jul 2025

### Updated

- Raise Keycloak hotfix version ([c557b90](https://github.com/KomMonitor/keycloak-extensions/commit/c557b9019d4329d8fdd0b55a1ebd1c39ee000ba1))

## [26.2.0]
> 10 Jul 2025

### Updated

- Raise Keycloak minor version ([bb7c6ce](https://github.com/KomMonitor/keycloak-extensions/commit/bb7c6cec943a02f5f03816511a0bb77e1cb7f78c))

## [26.1.3]
> 27 May 2025

### Updated

- Raise Keycloak hotfix version ([ba1ec2d](https://github.com/KomMonitor/keycloak-extensions/commit/ba1ec2d01c6c9645f800940c45b99cf79ca69fb5))
- Raise cache action version ([15d9060](https://github.com/KomMonitor/keycloak-extensions/commit/15d9060937288bf043015df08458f9e7a0b62d40))

## [26.1.0]
> 20 Jan 2025

### Updated

- Raise Keycloak minor version ([65d624c](https://github.com/KomMonitor/keycloak-extensions/commit/65d624cd9723e3e65e9d68dfb18512ead554aae6))

## [26.0.8]
> 14 Jan 2025

### Added

- Add hostname:v1 feature ([1990f62](https://github.com/KomMonitor/keycloak-extensions/commit/1990f62b95df9f810c38836eb00342a48e8283dd))
- Add support form realm dependent role policy evaluation ([1e5f49c](https://github.com/KomMonitor/keycloak-extensions/commit/1e5f49c0f1ca6aace0e79352818fa8f76ad8140c))
- Add dedicated role policy evaluation support for multiple realms ([f91f7ce](https://github.com/KomMonitor/keycloak-extensions/commit/f91f7ce7475bf65e39943219dca2ccc60c392a05))
- Add token-exchange feature ([3aaec6c](https://github.com/KomMonitor/keycloak-extensions/commit/3aaec6cbbee6cf3d7f20f57bd59886eee2c14866))

### Changed

- Pin Keycloak image version ([65befb8](https://github.com/KomMonitor/keycloak-extensions/commit/65befb8656969fed020deed8969a77cf0a6a1ad3))

### Fixed

- Fix extension artifact integration ([bad5457](https://github.com/KomMonitor/keycloak-extensions/commit/bad54570099be5bf819b51d77e3376f0109791aa))
- Fix custom provider integration in docker build ([6b4d449](https://github.com/KomMonitor/keycloak-extensions/commit/6b4d44947489affb6e37c93eaf2d2d47685e4216))
- Fix build target ([d762831](https://github.com/KomMonitor/keycloak-extensions/commit/d762831957b3b10fa8d4058f2ef8fa7804e47824))

### Removed

- Remove unsupported Keycloak feature ([507f391](https://github.com/KomMonitor/keycloak-extensions/commit/507f391c126297081d10899b3c1c4e72c46d3e31))

### Updated

- Raise Keycloak version ([3c1bff7](https://github.com/KomMonitor/keycloak-extensions/commit/3c1bff7e2bf193696f6a9692d3f886b1a1caa566))

## [25.0.6]
> 26 Nov 2024

### Added

- Add Dockerfile ([aa41cb0](https://github.com/KomMonitor/keycloak-extensions/commit/aa41cb0f592aed88860aac423f5ca1229b97a1a2))
- Add github workflows ([c9cdd5e](https://github.com/KomMonitor/keycloak-extensions/commit/c9cdd5edf1bfed540d5747e6e29e79c12e9864dd))

### Changed

- Init ([bdf4db7](https://github.com/KomMonitor/keycloak-extensions/commit/bdf4db773d023cd22d7b22bab39713a28f2ddff2))
- Disable trivy scan ([d7d2028](https://github.com/KomMonitor/keycloak-extensions/commit/d7d2028122f8ec6dfded1023944ca7e063d13867))
- Build for mssql + postgres separately ([27e7acd](https://github.com/KomMonitor/keycloak-extensions/commit/27e7acd516c3b0e42156a97e4bfcaa94ef683c03))

### Fixed

- Fix workflow file ([92ae73e](https://github.com/KomMonitor/keycloak-extensions/commit/92ae73e8cab625ec459183121bf80454ec389fe8))

[26.7.4]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.7.3..v26.7.4
[26.7.3]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.7.2..v26.7.3
[26.7.2]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.7.0..v26.7.2
[26.7.0]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.6.4..v26.7.0
[26.6.4]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.6.3..v26.6.4
[26.6.3]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.5.7..v26.6.3
[26.5.7]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.5.5..v26.5.7
[26.5.5]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.4.7..v26.5.5
[26.4.7]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.3.4..v26.4.7
[26.3.4]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.3.1..v26.3.4
[26.3.1]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.2.5..v26.3.1
[26.2.5]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.2.0..v26.2.5
[26.2.0]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.1.3..v26.2.0
[26.1.3]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.1.0..v26.1.3
[26.1.0]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.0.8..v26.1.0
[26.0.8]: https://github.com/KomMonitor/keycloak-extensions/compare/v25.0.6..v26.0.8
[25.0.6]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.7.4..v25.0.6

<!-- generated by git-cliff -->
