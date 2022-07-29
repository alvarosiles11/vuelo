# dms-vuelo



 <table border="1">
 <tr>
  <td>
     <img src="https://desktop.github.com/images/desktop-icon.svg" height="120" />
   </td>
  <td>
     <img src="https://seeklogo.com/images/S/sonarcloud-logo-39208B5388-seeklogo.com.png" height="120" />
   </td>
  <td>
     <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/DigitalOcean_logo.svg/1200px-DigitalOcean_logo.svg.png" height="120" />
   </td>
 </tr>
 <tr>
  <td>

 [📦](https://github.com/alvarosiles11/dms-vuelos)   github

   </td>
  <td>

 [📦](https://sonarcloud.io/projects)   sonarlint

   </td>
  <td>

 [📦](https://cloud.digitalocean.com/projects/)   digitalocean

   </td>
 </tr>
</table>


# pre-commit
formateo del código
ejecuten los unit tests

# flujo de CI
Compilación del código fuente
Ejecución de los unit tests

Análisis de código mediante sonarcloud
Reporte de code coverage para el código en sonarcloud.

# ramas

**rama main** bloqueadas para commit directo

**rama develop** bloqueadas para commit directo

El **action de Release** solo debería ejecutarse cuando se está haciendo un push a master.

**rama release: Job de compilación** ejecutar compilación y tests

**rama release: Job de release** ejecutar los comandos necesarios para realizar un release del código dentro de una máquina virtual en internet. puede hacerse mediante **conexión a SSH o docker**
esto es prueba