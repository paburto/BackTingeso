<template>
    <div class="container">
      <br>
      <h4 style="text-align:left; font-family:georgia"> <strong>Eliminar Producto</strong></h4>
      <br>
      <div class="col">
        <div class="row">
          <div>
          Id del producto: <input v-model="id" style="margin-left: 10px">
          </div>
       </div>
       <br>
      </div>

      <div class="center">

        <button type = "button" class="btn btn-success" style="float: left;" @click="deleteProducto">
              Eliminar Producto
      </button>

      </div>
    </div>
</template>

<script>
import axios from 'axios';

const localhost = 'http://localhost:8081';
export default {
  components: {
  },
  data(){
    return{
      id: '',
      errors: []
    }
  },
  methods: {
    deleteProducto() {
      var url = localhost + '/productos/delete/';
      var idString = "" + this.id;
      url = url + idString;
      axios.post(url, {
        id: this.id
      })
      .then(response => {
        this.id = "";
        alert("El producto ha sido eliminado con éxito.");
      })
      .catch(e => {
        this.errors.push(e)
      })
    },
  },
}
</script>
