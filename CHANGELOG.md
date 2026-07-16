# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [26.7.0]
> 16 Jul 2026

### Added

- Add dependabot config ([d3cf415](https://github.com/KomMonitor/keycloak-extensions/commit/d3cf4151adbe3a3e14d242f524024f0ff1ae7064))
- Add security documentation ([b626c33](https://github.com/KomMonitor/keycloak-extensions/commit/b626c33117981a29a231a987c786737b417120d9))
- Add cliff config and init CHANGELOG ([1621285](https://github.com/KomMonitor/keycloak-extensions/commit/1621285eb1def15817b252df74b0992909e08752))

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
[25.0.6]: https://github.com/KomMonitor/keycloak-extensions/compare/v26.6.4..v25.0.6

<!-- generated by git-cliff -->
