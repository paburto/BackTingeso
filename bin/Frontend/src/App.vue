<template>
  <div>
    <sidebar-menu class="sidebar-menu" :menu="menu" />
      <main class="main-container">
         <router-view></router-view>
      </main>
  </div>
</template>

<script>
  export default {
    data() {
      return{
        menu: [
          {
            href: '/',
            title: 'Principal',
            icon: 'fa fa-home'
          },
          {
            href: '/listar',
            title: 'Listar Productos',
            icon: 'fa fa-align-left'
          },
          { title: 'Opciones',
            icon: 'fa fa-shopping-cart',
            child: [
              {
                href: '/eliminar',
                title: 'Eliminar Producto',
                icon: 'fa fa-trash'
              },
              {
                href: '/agregar',
                title: 'Agregar Producto',
                icon: 'fa fa-plus'
              },
              {
                href: '/modificar',
                title: 'Modificar Producto',
                icon: 'fa fa-pencil'
              },
             ]
          },
         ]
        }
      }
    }
</script>
