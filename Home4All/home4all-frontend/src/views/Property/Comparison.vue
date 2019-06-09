<template>
  <b-container class="mt-3">
    <b-row>
      <b-col>
        <b-table bordered striped hover :fields="fields" :items="items">
          <template slot="col1" slot-scope="row">
            <label v-if="row.index != 1 && row.index != 5">{{ row.value }}</label>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <b-button variant="primary" v-if="row.index == 5" @click="goToProperty(row.value)">Ver detalhes</b-button>
          </template>
          <template slot="col2" slot-scope="row">
            <label v-if="row.index != 1 && row.index != 5">{{ row.value }}</label>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <b-button variant="primary" v-if="row.index == 5" @click="goToProperty(row.value)">Ver detalhes</b-button>
          </template>
          <template slot="col3" slot-scope="row">
            <label v-if="row.index != 1 && row.index != 5">{{ row.value }}</label>
            <img v-if="row.index == 1" src="../../assets/logo.png"/>
            <b-button variant="primary" v-if="row.index == 5" @click="goToProperty(row.value)">Ver detalhes</b-button>
          </template>
        </b-table>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'

export default {
  name: 'comparison',
  data: () => ({
    headers: [
      'type',
      'typology',
      'area',
      'furnished',
      'availability',
      'rentPrice',
      'sellPrice',
      'distance',
      'rentInc',
      'contact'
    ],
    props: [
      { id: 1, images: 'img1', name: 'nome1', tipo: 'tipo1', area: 100, link: '1' },
      { id: 2, images: 'img2', name: 'nome2', tipo: 'tipo2', area: 200, link: '2' },
      { id: 3, images: 'img3', name: 'nome3', tipo: 'tipo3', area: 300, link: '3' }
    ]
  }),
  created () {
    // TODO: Remover quando o backend tiver feito
    this.props.forEach(p => {
      this.addPropCompare(p)
    })
    this.setProperties(this.props)
  },
  computed: {
    ...mapState({
      properties: state => state.properties.properties,
      props_compare: state => state.properties.props_compare
    }),
    fields () {
      var fields = []
      fields.push({
        key: 'col0',
        label: 'Parâmetros'
      })
      for (var i in this.props_compare) {
        i++
        fields.push({
          key: 'col' + i,
          label: 'Imóvel ' + i
        })
      }
      return fields
    },
    items () {
      var listParsed = []
      var keys = Object.keys(this.props_compare[0])
      keys.forEach(key => {
        listParsed.push(this.translateInfo(this.props_compare, key))
      })
      return listParsed
    }
  },
  methods: {
    ...mapActions('properties', [
      'setProperty',
      'addPropCompare',
      'setProperties'
    ]),
    translateInfo (props, key) {
      var i = 0; var content = {}
      content['col' + i++] = key
      props.map(p => p[key]).forEach(function (item) {
        content['col' + i++] = item
      })
      content['_cellVariants'] = { col0: 'warning' }
      return content
    },
    goToProperty (id) {
      // eslint-disable-next-line
      console.log(id)
      this.setProperty(this.properties.find(p => p.id == id))
      this.$router.push({ name: 'propertyView' })
    }
  }
}
</script>

<style scope>
thead {
  background-color: #FFA64C;
}

.table-warning,
.table-warning > th,
.table-warning > td {
  background-color: #FFA64C !important;
}

@media (max-width: 576px) {
  .table-warning,
  .table-warning > th,
  .table-warning > td {
    display: none;
  }
  thead th:first-child{
    display: none;
  }
}
</style>
