<template>
    <div class="container">
      <br>
      <h4 style="text-align:left; font-family:georgia"> <strong>Agregar Producto</strong></h4>
      <br>
      <div class="col">
        <div class="row">
          <div>
          Nombre del producto: <input v-model="nombre_producto" style="margin-left: 20px">
          </div>
       </div>
       <br>
       <div class="row">
          Código del producto: <input v-model="codigo_producto" style="margin-left: 28px">
        </div>
        <br>
        <div class="row">
          Categoría del producto: <input v-model="categoria_producto" style="margin-left: 10px">
         </div>
         <br>
         <div class="row">
          Fecha de vencimiento: <input v-model="fecha_vencimiento" style="margin-left: 15px">
          </div>
          <br>
          <div class="row">
          Precio del producto: <input v-model="precio_producto" style="margin-left: 35px">
           </div>
      </div>
      <div class="center">

        <button type = "button" class="btn btn-success" style="float: left;" @click="postProducto">
              Agregar Producto
      </button>

      </div>
    </div>
</template>

<script>
import axios from 'axios';

const localhost = 'http://localhost:8081';
export default {
  name : 'agregarProducto',
  props: ['postId'],
  components: {
  },
  data(){
    return{
      nombre_producto:'',
      codigo_producto:'',
      categoria_producto:'',
      fecha_vencimiento:'',
      precio_producto:'',
      errors: []
    }
  },
  methods: {
    postProducto() {
      const url = localhost + '/productos/create';
      axios.post(url, {
        nombre_producto : this.nombre_producto,
        codigo_producto : this.codigo_producto,
        categoria: this.categoria_producto,
        fecha_vencimiento: this.fecha_vencimiento,
        precio: this.precio_producto
      })
      .then(response => {
        this.nombre_producto = "";
        this.codigo_producto = "";
        this.categoria_producto = "";
        this.fecha_vencimiento = "";
        this.precio_producto = "";
      })
      .catch(e => {
        this.errors.push(e)
      })
    },
  }
}
</script>
