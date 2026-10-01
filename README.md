# Java Console Playlist Manager

Aplicación de consola en Java SE orientada a la gestión integral de canciones y listas de reproducción en memoria estática con persistencia en el sistema de archivos local.

---

## Características principales

- **Control sobre memoria estática:** Implementación con arrays de longitud fija, gestionando manualmente índices, verificación de huecos libres (`null`) y límites de capacidad.
- **Operaciones CRUD:**
  - Registro de canciones con nombre y duración.
  - Listado completo en consola.
  - Búsqueda secuencial exacta de títulos.
  - Cálculo de duración acumulada y obtención del tema de mayor duración.
  - Eliminación segura de pistas.
- **Persistencia en disco:**
  - **Exportación:** Escritura secuencial en archivo plano (`Playlist.txt`) en el directorio del usuario (`System.getProperty("user.home")`), garantizando la creación de directorios intermedios mediante `File.mkdirs()`.
  - **Importación:** Lectura controlada con `BufferedReader`, rellenando posiciones disponibles sin sobreescribir datos existentes ni desbordar el array.
- **Robustez y control de excepciones:**
  - Cierre seguro de flujos I/O mediante sentencias `try-with-resources`.
  - Gestión de errores de entrada por consola (`InputMismatchException`) para prevenir bucles infinitos y terminaciones abruptas.
  - Manejo de excepciones de entrada/salida (`IOException`).

---

## Estructura del proyecto

```text
├── src/
│   ├── Main.java       # Menú interactivo por consola y control de flujo
│   └── Playlist.java   # Lógica de negocio, gestión del array y persistencia I/O
├── .gitignore
└── README.md