# AutomationCorebank - InicioSession Only

Proyecto automatizado con Selenium + Cucumber + TestNG.

## Arquitectura activa

```text
Scenarios/
└── inicioSession/
    └── inicioSession.feature

src/test/java/com/automation/
├── core/
│   ├── DriverManager.java
│   ├── BasePage.java
│   └── ScreenshotUtil.java
├── config/
│   └── ConfigManager.java
├── features/
│   └── login/
│       ├── LoginPage.java
│       ├── LoginBusiness.java
│       └── LoginSteps.java
└── runners/
    └── LoginRunner.java
```

## Ejecucion

```bash
mvn clean test
```

o solo runner de login:

```bash
mvn clean test -Dtest=LoginRunner
```

## URL base

Se toma desde `src/test/resources/config/environment.config`:

```properties
base.url=http://10.20.22.50/SistemaMantis/login_page.php
```

Tambien puedes sobrescribirla al ejecutar:

```bash
mvn clean test -Dbase.url=http://10.20.22.50/SistemaMantis/login_page.php
```
