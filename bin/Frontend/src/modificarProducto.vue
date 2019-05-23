<template>
    <div class="container">
      <br>
      <h4 style="text-align:left; font-family:georgia"> <strong>Modificar Producto</strong></h4>
      <br>
      <div class="col">
        <br>
        <div class="row">
           Id del producto: <input v-model="id" style="margin-left: 7%">
         </div>
         <br>
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

        <button type = "button" class="btn btn-success" style="float: left;" @click="putProducto">
              Modificar Producto
      </button>

      </div>
    </div>
</template>

<script>
import axios from 'axios';

const localhost = 'http://localhost:8081';
export default {
  name : 'modificarProducto',
  props: ['postId'],
  components: {
  },
  data(){
    return{
      id: '',
      nombre_producto:'',
      codigo_producto:'',
      categoria_producto:'',
      fecha_vencimiento:'',
      precio_producto:'',
      productos: [],
      errors: []
    }
  },
  methods: {
    putProducto() {
      var url = localhost + '/productos/update/';
      var idString = "" + this.id;
      url = url + idString;
      axios.post(url, {
        nombre_producto : this.nombre_producto,
        codigo_producto : this.codigo_producto,
        categoria: this.categoria_producto,
        fecha_vencimiento: this.fecha_vencimiento,
        precio: this.precio_producto
      })
      .then(response => {
        this.id = "";
        this.nombre_producto = "";
        this.codigo_producto = "";
        this.categoria_producto = "";
        this.fecha_vencimiento = "";
        this.precio_producto = "";
        alert("El producto ha sido modificado exitosamente.");
      })
      .catch(e => {
        this.errors.push(e)
      })
    },
  },
}
</script>
