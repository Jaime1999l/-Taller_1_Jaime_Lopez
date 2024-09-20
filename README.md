https://github.com/Jaime1999l/-Taller_1_Jaime_Lopez.git

Jaime López Díaz

# Taller 1 - Aplicación Android

## Descripción del Proyecto

Este proyecto es una aplicación de Android desarrollada en **Android Studio** utilizando **Java**. La aplicación tiene como objetivo principal gestionar un saludo personalizado según la hora del día y permite al usuario configurar el fondo de pantalla, ya sea con colores planos o imágenes predefinidas. La aplicación cuenta con tres actividades principales:

1. **MainActivity**: Muestra un saludo personalizado y el nombre del usuario (si se ha configurado).
2. **PrincipalActivity**: Permite al usuario ingresar su nombre y guardar la información en un ViewModel.
3. **ConfiguracionActivity**: Proporciona opciones para cambiar el fondo de pantalla de la aplicación.


### Descripción de Archivos Importantes

- **`MainActivity.java`**: Gestiona el saludo personalizado basado en la hora y muestra el nombre del usuario.
- **`PrincipalActivity.java`**: Permite al usuario ingresar y guardar su nombre, observando los cambios en el `UserViewModel`.
- **`ConfiguracionActivity.java`**: Proporciona opciones para cambiar el fondo de la aplicación, ya sea con un color plano o una imagen predefinida.
- **`UserViewModel.java`**: ViewModel que gestiona el estado del nombre del usuario en la aplicación.
- **Layouts (`.xml`)**: Definen las vistas y estructuras visuales de las actividades.

## Requisitos del Sistema

- **Android Studio** versión 4.0 o superior.
- **Java Development Kit (JDK)** 8 o superior.
- **SDK de Android** 30 o superior.

## Instalación

1. Clonar el repositorio:

    ```bash
    git clone https://github.com/usuario/taller1-android.git
    ```

2. Abrir el proyecto en **Android Studio**.

3. Sincronizar el proyecto con Gradle y descargar las dependencias necesarias.

4. Ejecutar el proyecto en un dispositivo o emulador con Android 8.0 (Oreo) o superior.

## Uso de la Aplicación

### 1. Pantalla de Inicio (MainActivity)

- Muestra un saludo personalizado que cambia según la hora del día (`¡Buenos días!`, `¡Buenas tardes!`, `¡Buenas noches!`).
- Muestra el nombre del usuario (si se ha configurado).
- Botón para navegar a la `PrincipalActivity`.

### 2. Actividad Principal (PrincipalActivity)

- Permite ingresar el nombre del usuario en un campo de texto (`EditText`).
- Botón para guardar el nombre ingresado.
- Muestra el nombre guardado en tiempo real utilizando un `ViewModel`.
- Botón para ir a la pantalla de configuración.

### 3. Pantalla de Configuración (ConfiguracionActivity)

- Opciones para cambiar el fondo de la aplicación:
    - Fondos planos de colores (Rojo, Verde, Azul).
    - Imágenes predefinidas.
- Guarda la selección del fondo en `SharedPreferences`.
- Botón para volver a la pantalla de inicio (`MainActivity`).

## Mejora Propuesta

Se puede implementar, en futuras actualizaciones:

1. **Implementación de Fragmentos** para mejorar la modularidad de las actividades.
2. **Compatibilidad con diferentes tamaños de pantalla** mediante `ConstraintLayout` y `Dimens`.
3. **Internacionalización** para soportar múltiples idiomas.

