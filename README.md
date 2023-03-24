# TALLER 7:   CONSTRUIR UNA APLICACIÓN SEGURA
Se construye una aplicación con una arquitectura que incluye dos servicios, y que cumplen con los siguientes parametros:
1. Garantiza integridad, autorización, autenticación a nivel de usuario
2. Garantiza integridad, autorización, autenticación a nivel de servidores 
3. Usar 2 servidores en el BackEnd
4. Desplegar el experimento en AWS. 
![Arquitectura](https://i.imgur.com/9d1ttHm.png)

---
### Prerrequisitos
Para elaborar este proyecto requerimos de las siguientes tecnologías:

 - **[Maven](https://openwebinars.net/blog/que-es-apache-maven/)**: Apache Maven es una herramienta que estandariza la configuración de un proyecto en todo su ciclo de vida.
 - **[Git](https://learn.microsoft.com/es-es/devops/develop/git/what-is-git)**: Es un sistema de control de versiones distribuido (VCS).

---
### Instalación
instalamos Java en nuestras instancias EC2

	 sudo yum install java-17-amazon-corretto.x86_64

Clonamos el repositorio

     git clone https://github.com/jorge-stack/Taller_07.git
    
Se accede al repositorio que acabamos de clonar

	 cd Taller_07

Hacemos la construcción del proyecto

	 mvn clean package install
---
### Corriendo
Una vez creadas las instancias (Una para cada servicio y la base de datos mongo)
![Instancias](https://i.imgur.com/L6fHK1j.png)

Se clona el repositorio donde alojamos el proyecto
	
     git clone https://github.com/jorge-stack/Taller_07.git

y nos posicionamos en la carpeta root del proyecto

	 cd Taller_07

una vez aquí debemos levantar el servicio que le corresponde a dicha instancia EC2

	 java -cp "target/classes:target/dependency/*" org.myorg.apps.LoginApp
	 java -cp "target/classes:target/dependency/*" org.myorg.apps.BasicApp

### LogInService
![App](https://i.imgur.com/i0JdM6D.png)

### HelloService
![HelloService](https://i.imgur.com/ZiMnrlJ.png)

### Run
Una vez tenemos corriendo todos los servicios, ahora podremos acceder al servicio principal, 

	 {DnsPublicoAppRoundRobin}:7654/login

En el caso, el aplicativo web recibe por el input cualquier cadena de texto y lo distribuye de manera equitativa por los servicios de log distribuidos que se presentan en el modelo de la arquitectura, esto gracias a la implementación del algoritmo de Round Robin de balanceo de cargas. el aplicativo regresara en formato JSON los 10 últimos inputs almacenados en la base de datos junto con su fecha de creación.
### LogIn
![Imgur](https://i.imgur.com/jpWnvNB.png)
### BadCredentials
![Wrong](https://i.imgur.com/nPjzuZG.png)
### Success
![Success](https://i.imgur.com/9v1B00W.png)
Los usuarios registrados son:
* jorge -> 123456
* laura -> astro123

	
---
## Construido con

* [Maven](https://maven.apache.org/): Apache Maven es una herramienta que estandariza la configuración de un proyecto en todo su ciclo de vida.
* [Git](https://rometools.github.io/rome/):  Es un sistema de control de versiones distribuido (VCS).
* [IntelliJ](https://www.jetbrains.com/idea/): Es un entorno de desarrollo integrado para el desarrollo de programas informáticos.
* [Java 19](https://www.java.com/es/): Lenguaje de programación de propósito general, es decir, que sirve para muchas cosas, para web, servidores, aplicaciones móviles, entre otros. Java también es un lenguaje orientado a objetos, y con un fuerte tipado de variables.
* [Html](https://developer.mozilla.org/es/docs/Learn/Getting_started_with_the_web/HTML_basics): Es el código que se utiliza para estructurar y desplegar una página web y sus contenidos.
* [JavaScript](https://developer.mozilla.org/es/docs/Learn/JavaScript/First_steps/What_is_JavaScript): JavaScript es un lenguaje de programación o de secuencias de comandos que te permite implementar funciones complejas en páginas web
* [CSS](https://developer.mozilla.org/es/docs/Learn/CSS/First_steps/What_is_CSS): Las hojas de estilo en cascada permiten crear páginas web atractivas.
* [AWS](https://www.inbest.cloud/comunidad/qu%C3%A9-es-aws): Amazon Web Services es una plataforma de servicios de nube que te ofrece potencia de cómputo, almacenamiento de bases de datos, entrega de contenido y otra funcionalidad para ayudar a tu negocio a escalar y crecer

## Autor
* **[Jorge David Saenz Diaz](https://co.linkedin.com/in/jorgedsaenzd/en)**  - [Jorge-Stack](https://github.com/jorge-stack?tab=repositories)

## Licencia
**©** Jorge David Saenz Diaz, Estudiante de Ingeniería de Sistemas de la Escuela Colombiana de Ingeniería Julio Garavito.
