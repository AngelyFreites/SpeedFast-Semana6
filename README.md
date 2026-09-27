# SpeedFast - Semana 6

## Descripción

El proyecto implementa una interfaz gráfica de escritorio para la gestión de pedidos de la empresa SpeedFast.

El sistema permite:

- Registrar nuevos pedidos.
- Visualizar los pedidos registrados.
- Asignar un repartidor a un pedido.
- Simular el inicio de una entrega.
- Actualizar y visualizar el estado de los pedidos.

## Estructura del proyecto

El proyecto se encuentra organizado en los siguientes paquetes:

### modelo
Contiene las clases encargadas de representar y gestionar los datos:

- `Pedido`
- `GestorPedidos`

### vista
Contiene las interfaces gráficas desarrolladas con Java Swing:

- `VentanaPrincipal`
- `VentanaRegistroPedido`
- `VentanaListaPedidos`
- `VentanaAsignarRepartidor`

### main
Contiene la clase:

- `Main`

Esta clase inicia la ejecución de la aplicación y muestra la ventana principal.

## Funcionalidades

### Registro de pedidos
Permite ingresar:

- ID del pedido.
- Dirección.
- Tipo de pedido: Comida, Encomienda o Express.

Se realizan validaciones para evitar campos vacíos, IDs inválidos o IDs duplicados.

### Listado de pedidos
Los pedidos registrados se muestran mediante una `JTable` utilizando `DefaultTableModel`.

La tabla muestra:

- ID
- Dirección
- Tipo
- Repartidor
- Estado

### Asignación de repartidor

Permite buscar un pedido mediante su ID, asignarle un repartidor y cambiar su estado de `Pendiente` a `En reparto`.

## Almacenamiento

Los pedidos se almacenan temporalmente en memoria mediante una lista compartida administrada por la clase `GestorPedidos`.
