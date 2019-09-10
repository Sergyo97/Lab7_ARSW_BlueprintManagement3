
# Blueprint Management 2 Laboratory


## Description

In this exercise, the BlueprintsRESTAPI component will be built, which will allow managing the architectural plans of a prestigious design company. The idea of this API is to offer a standardized and _platform independent_ means so that the tools developed in the future for the company can manage the plans centrally. The following is the component diagram that corresponds to the architectural decisions raised at the beginning of the project:

![Components Diagram](https://github.com/Sergyo97/Lab6_ARSW_BlueprintManagement2/blob/master/img/CompDiag.png)

![Class Diagram](https://github.com/Sergyo97/Lab6_ARSW_BlueprintManagement2/blob/master/img/ClassDiagram.png)

### Part III

 - What race conditions could occur?
	 - Perform a GET and a PUT at the same time on the same blueprint.
	 - Trying to modify a blueprint in two different instances at the same time.
 - What are the respective critical regions?
	 - The corresponding critical region is the Blueprints HashMap.

## Running

Compile first time the project after downloaded.

    mvn package
    
To run the whole spring boot project.

    mvn spring-boot:run

## Authors
Michael Sebastián Preciado Garzón - Escuela Colombiana de Ingeniería Julio Garavito

Sergio Hernando Ruiz Paez - Escuela Colombiana de Ingeniería Julio Garavito

## License
This project is under GNU General Public License - see  [LICENSE](https://github.com/Sergyo97/Lab6_ARSW_BlueprintManagement2/blob/master/LICENSE) to more info.