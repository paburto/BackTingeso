<template>
    <div class="container">
      <br>
      <h4 style="text-align:left; font-family:georgia"> <strong>Listar Productos </strong></h4>
      <br>
      <div class="col">
        <div class="row">
            <br><br><br><br>
            <!--Combobox-->
            <label for="select">Seleccione una categoria:</label>
            <br><br>
                  <div class="styled-select slate" style="margin-left: 10px">
                       <select v-model="categoria_seleccionado">
                       <option value=0 disabled selected style="width: 100px; font-family: georgia">Seleccionar categoría</option>
                       <option @click.prevent="seleccionarCategoria"
                           style="width: 100px; font-family: georgia"
                           v-for="categoria in categorias"
                           v-bind:key="categoria.idCategoria"
                           v-bind:value="categoria.idCategoria"> {{ categoria.nombreCategoria }}
                       </option>
                       </select>
                  </div>
            <br>
       </div>
       <br>
       <div class="row">
            <!--Lista de productos filtrados-->
            <ul class="list-group">
                <li v-for="producto in productos_filtrados"
                    style = "height: 50px; font-family: georgia; text-align: center"
                    class = "list-group-item"> {{ producto.nombre_producto}}  ${{ producto.precio}}
                    <br>
                </li>
                <br>
            </ul>
            <br>
            <br>
        </div>
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
      productos: [],
      selected: '',
      categorias: [],
      productos_filtrados: [],
      categoria_seleccionado: 0,
    }
  },
  methods: {
    getProductos(){
      const url = localhost + '/productos';
      axios.get(url).then((data) => {
        this.productos = data.data;
        this.getCategorias();
      });
    },
    getCategorias(){
      var aux, bool, k = 1;
      for(let i = 0;i < this.productos.length; i++){
        if(this.categorias.length == 0){
          aux = {
            'idCategoria': k,
            'nombreCategoria': this.productos[i].categoria
          };
          this.categorias.push(aux);
          k++;
          i++;
        }
        bool = false;
        for(let j = 0;j < this.categorias.length; j++){
          if(this.categorias[j].nombreCategoria == this.productos[i].categoria){bool = true;}
        }
        if(bool){}
        else{
          aux = {
            'idCategoria': k,
            'nombreCategoria': this.productos[i].categoria
          };
          k++;
          this.categorias.push(aux);
        }
      }
    },
    seleccionarCategoria(){
      //Se seleccionan los productos correspondientes a esa categoría seleccionada
      console.log(this.categorias.length);
      var categoria;
      this.productos_filtrados = [];
      for(let i = 0; i < this.categorias.length; i++){
        if(this.categorias[i].idCategoria == this.categoria_seleccionado){
          categoria = this.categorias[i];
        }
      }
      for(let i = 0; i < this.productos.length; i++){
        if(this.productos[i].categoria == categoria.nombreCategoria){

          this.productos_filtrados.push(this.productos[i]);
        }
      }
    },
  },

  mounted() {
    this.getProductos();
  }
}
</script>
