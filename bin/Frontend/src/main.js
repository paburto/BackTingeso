import Vue from 'vue';
import VueRouter from 'vue-router';
import Index from './Index.vue';
import VueResource from 'vue-resource';

import Agregar from './agregarProducto.vue';
import Modificar from './modificarProducto.vue';
import Eliminar from './eliminarProducto.vue';
import Listar from './listarProducto.vue';


require("./style.scss");


import App from './App.vue';
import VueSidebarMenu from 'vue-sidebar-menu';

Vue.use(VueSidebarMenu);
Vue.use(VueRouter);
Vue.use(VueResource);

const routes = [
  { path: '/index', alias: '/', component:Index },

  { path: '/agregar', component: Agregar},
  { path: '/eliminar', component: Eliminar},
  { path: '/listar', component: Listar},
  { path: '/modificar', component: Modificar},

]

// Create the router instance and pass the `routes` option
const router = new VueRouter({
  routes,
  scrollBehavior (to, from, savedPosition) {
     return { x: 0, y: 0 }
  }
});

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
