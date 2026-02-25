@InicioSession @login
Feature: Inicio de Sesion - MANTISBT
  Como usuario de mantisbt
  Quiero poder iniciar sesion con mis credenciales
  Para acceder al sistema

  Background:
    Given que el usuario abre el navegador y accede al sistema

  @Login @mantisbt @funcional
  Scenario Outline: Inicio de sesion exitoso
    When el usuario ingresa el correo "<user>"
    And el usuario hace click en ingresar
    And el usuario ingresa la contrasena "<password>"
    And el usuario hace clic en el boton iniciar session
    Then el usuario debe ver el dashboard principal con el mensaje "<mensaje>" y "<usuario>"


    Examples:
      | user   | password     | mensaje    | usuario |
      | Jgomez | Calidad#1234 | smaller-75 | Jgomez  |
