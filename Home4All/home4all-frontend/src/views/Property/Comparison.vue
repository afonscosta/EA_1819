<template>
  <div>
    <b-modal
      ref="modal-map"
      centered
      size="lg"
      hide-footer title="Localização do imóvel"
    >
      <google-map :marker="marker"/>
    </b-modal>

    <b-modal
      ref="modal-images"
      centered
      size="lg"
      hide-footer title="Imagens do imóvel"
    >
      <Images class="images" :images="images"/>
    </b-modal>

    <b-container class="mt-3">
      <b-row v-if="num_props_compare === 0">
        <b-col>
          <h4 class="mt-4">Não foram acrescentados imóveis à comparação</h4>
        </b-col>
      </b-row>
      <b-row v-if="num_props_compare > 0">
        <b-col class="p-0">
          <b-table bordered striped hover :fields="fields" :items="items">
            <template slot="col1" slot-scope="row">
              <label v-if="row.index != 0 && row.index != 9 && row.index != 10 && row.index != 11 && row.index != 12">{{ row.value }}</label>
              <b-row>
                <b-col>
                  <label v-if="row.index == 9">{{ row.value.nome }}</label>
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <label v-if="row.index == 9">{{ row.value.phone }}</label>
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <a v-if="row.index == 9" :href="'mailto:' + row.value.email">{{ row.value.email }}</a>
                </b-col>
              </b-row>
              <div v-if="row.index == 0">
                <ImagesPreview :imgs="row.value" :numImgPreview="numImgPreview" @showLightbox="showLightbox"/>
              </div>
              <b-row>
                <b-col>
                  <label v-if="row.index == 10"><strong>Endereço:&nbsp;</strong></label>
                  <label v-if="row.index == 10">{{ row.value.addr }}</label>
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <b-button variant="primary" v-if="row.index == 10" @click="openMap(row.value.loc)">Localização</b-button>
                </b-col>
              </b-row>
              <b-button variant="primary" v-if="row.index == 11" @click="goToProperty(row.value)">Ver detalhes</b-button>
              <b-button variant="danger" v-if="row.index == 12" @click="removePropCompare(row.value)">Remover</b-button>
            </template>
            <template slot="col2" slot-scope="row">
              <label v-if="row.index != 0 && row.index != 9 && row.index != 10 && row.index != 11 && row.index != 12">{{ row.value }}</label>
              <b-row>
                <b-col>
                  <label v-if="row.index == 9">{{ row.value.nome }}</label>
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <label v-if="row.index == 9">{{ row.value.phone }}</label>
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <a v-if="row.index == 9" :href="'mailto:' + row.value.email">{{ row.value.email }}</a>
                </b-col>
              </b-row>
              <div v-if="row.index == 0">
                <ImagesPreview :imgs="row.value" :numImgPreview="numImgPreview" @showLightbox="showLightbox"/>
              </div>
              <b-row>
                <b-col>
                  <label v-if="row.index == 10"><strong>Endereço:&nbsp;</strong></label>
                  <label v-if="row.index == 10">{{ row.value.addr }}</label>
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <b-button variant="primary" v-if="row.index == 10" @click="openMap(row.value.loc)">Localização</b-button>
                </b-col>
              </b-row>
              <b-button variant="primary" v-if="row.index == 11" @click="goToProperty(row.value)">Ver detalhes</b-button>
              <b-button variant="danger" v-if="row.index == 12" @click="removePropCompare(row.value)">Remover</b-button>
            </template>
            <template slot="col3" slot-scope="row">
              <label v-if="row.index != 0 && row.index != 9 && row.index != 10 && row.index != 11 && row.index != 12">{{ row.value }}</label>
              <label v-if="row.index == 9">{{ row.value.nome }}</label>
              <label v-if="row.index == 9">{{ row.value.phone }}</label>
              <a v-if="row.index == 9" :href="'mailto:' + row.value.email">{{ row.value.email }}</a>
              <div v-if="row.index == 0">
                <ImagesPreview :imgs="row.value" :numImgPreview="numImgPreview" @showLightbox="showLightbox"/>
              </div>
              <b-row>
                <b-col>
                  <label v-if="row.index == 10"><strong>Endereço:&nbsp;</strong></label>
                  <label v-if="row.index == 10">{{ row.value.addr }}</label>
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <b-button variant="primary" v-if="row.index == 10" @click="openMap(row.value.loc)">Localização</b-button>
                </b-col>
              </b-row>
              <b-button variant="primary" v-if="row.index == 11" @click="goToProperty(row.value)">Ver detalhes</b-button>
              <b-button variant="danger" v-if="row.index == 12" @click="removePropCompare(row.value)">Remover</b-button>
            </template>
          </b-table>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { mapGetters, mapActions, mapState } from 'vuex'
import GoogleMap from '@/components/GoogleMap'
import Images from '@/components/Property/DetailView/Images'
import ImagesPreview from '@/components/ImagesPreview'

export default {
  name: 'comparison',
  components: {
    GoogleMap,
    ImagesPreview,
    Images
  },
  data: () => ({
    headers: [
      { value: 'images', text: 'Imagens' },
      { value: 'type', text: 'Tipo' },
      { value: 'typology', text: 'Tipologia' },
      { value: 'area', text: 'Área' },
      { value: 'furnished', text: 'Mobilado' },
      { value: 'availability', text: 'Disponibilidade' },
      { value: 'rentPrice', text: 'Preço para arrendar' },
      { value: 'sellPrice', text: 'Preço para compra' },
      { value: 'expensesIncluded', text: 'Despesas incluídas' },
      { value: 'owner', text: 'Contacto' },
      { value: 'map', text: 'Localização' },
      { value: 'id', text: 'Detalhes' },
      { value: 'id', text: 'Remover' }
    ],
    images: [],
    numImgPreview: 3,
    marker: null
  }),
  created () {
    console.log('properties created', this.properties)
  },
  computed: {
    ...mapGetters('properties', [ 'num_props_compare' ]),
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
          label: this.props_compare[i - 1].name
        })
      }
      return fields
    },
    items () {
      var listParsed = []
      // var keys = Object.keys(this.props_compare[0])
      this.headers.forEach(key => {
        listParsed.push(this.translateInfo(this.props_compare, key))
      })
      return listParsed
    }
  },
  methods: {
    ...mapActions('properties', [
      'setProperty',
      'addPropCompare',
      'removePropCompare',
      'setProperties'
    ]),
    translateInfo (props, key) {
      var i = 0; var content = {}
      content['col' + i++] = key.text
      if (key.value === 'map') {
        props.map(p => {
          return { addr: p.address, loc: { lat: p.lat, lng: p.lng } }
        }).forEach((item) => {
          content['col' + i++] = item
        })
      } else if (key.value === 'type') {
        props.map(p => p[key.value]).forEach((item) => {
          content['col' + i++] = this.parseType(item)
        })
      } else if (key.value === 'typology') {
        props.map(p => p[key.value]).forEach((item) => {
          // eslint-disable-next-line
          content['col' + i++] = item ? item : '-'
        })
      } else if (key.value === 'area') {
        props.map(p => p[key.value]).forEach((item) => {
          content['col' + i++] = item + ' m²'
        })
      } else if (key.value === 'rentPrice') {
        props.map(p => p[key.value]).forEach((item) => {
          content['col' + i++] = item ? item + ' €/mês' : '-'
        })
      } else if (key.value === 'sellPrice') {
        props.map(p => p[key.value]).forEach((item) => {
          content['col' + i++] = item ? item + ' €' : '-'
        })
      } else if (key.value === 'furnished') {
        props.map(p => p[key.value]).forEach((item) => {
          content['col' + i++] = item ? 'Sim' : 'Não'
        })
      } else if (key.value === 'expensesIncluded') {
        props.map(p => p[key.value]).forEach((item) => {
          content['col' + i++] = item.toString() !== '' ? item.toString() : '-'
        })
      } else if (key.value === 'availability') {
        props.map(p => p[key.value]).forEach((item) => {
          content['col' + i++] = (new Date(item)).toLocaleDateString('en-GB')
        })
      } else {
        props.map(p => p[key.value]).forEach((item) => {
          content['col' + i++] = item
        })
      }
      content['_cellVariants'] = { col0: 'warning' }
      return content
    },
    prettyPrintOwner (owner) {
      return 'Telemóvel: ' + owner.phone + '\nNome: ' + owner.nome + '\nEmail: ' + owner.email
    },
    parseType (type) {
      if (type === 'bedrooms') return 'Quartos'
      if (type === 'apartment') return 'Apartamento'
      if (type === 'villa') return 'Vivenda'
      if (type === 'single') return 'Individual'
      if (type === 'double') return 'Casal'
      if (type === 'multiple') return 'Múltiplo'
    },
    goToProperty (id) {
      var prop = this.properties.find(p => p.id === id)
      this.setProperty(prop)
      this.$router.push({ name: 'propertyView' })
    },
    openMap (value) {
      this.marker = value
      this.$refs['modal-map'].show()
    },
    showLightbox (imgs) {
      this.images = imgs
      this.$refs['modal-images'].show()
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
    display: none !important;
  }
  thead th:first-child{
    display: none !important;
  }
}

.images img {
  position: relative;
  float: left;
  width:200px;
  height:200px;
  object-fit:scale-down;
}
</style>
