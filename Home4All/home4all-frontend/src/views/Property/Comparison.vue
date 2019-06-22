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
      <b-row>
        <b-col>
          <b-table bordered striped hover :fields="fields" :items="items">
            <template slot="col1" slot-scope="row">
              <label v-if="row.index != 0 && row.index != 10 && row.index != 11">{{ row.value }}</label>
              <div v-if="row.index == 0">
                <ImagesPreview :imgs="row.value" :numImgPreview="numImgPreview" @showLightbox="showLightbox"/>
              </div>
              <b-button variant="primary" v-if="row.index == 10" @click="openMap(row.value)">Localização</b-button>
              <b-button variant="primary" v-if="row.index == 11" @click="goToProperty(row.value)">Ver detalhes</b-button>
            </template>
            <template slot="col2" slot-scope="row">
              <label v-if="row.index != 0 && row.index != 10 && row.index != 11">{{ row.value }}</label>
              <div v-if="row.index == 0">
                <ImagesPreview :imgs="row.value" :numImgPreview="numImgPreview" @showLightbox="showLightbox"/>
              </div>
              <b-button variant="primary" v-if="row.index == 10" @click="openMap(row.value)">Localização</b-button>
              <b-button variant="primary" v-if="row.index == 11" @click="goToProperty(row.value)">Ver detalhes</b-button>
            </template>
            <template slot="col3" slot-scope="row">
              <label v-if="row.index != 0 && row.index != 10 && row.index != 11">{{ row.value }}</label>
              <div v-if="row.index == 0">
                <ImagesPreview :imgs="row.value" :numImgPreview="numImgPreview" @showLightbox="showLightbox"/>
              </div>
              <b-button variant="primary" v-if="row.index == 10" @click="openMap(row.value)">Localização</b-button>
              <b-button variant="primary" v-if="row.index == 11" @click="goToProperty(row.value)">Ver detalhes</b-button>
            </template>
          </b-table>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
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
      'images',
      'type',
      'typology',
      'area',
      'furnished',
      'availability',
      'rentPrice',
      'sellPrice',
      'expensesIncluded',
      'contact',
      'map',
      'link'
    ],
    images: [],
    numImgPreview: 4,
    marker: null
  }),
  created () {
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
      'setProperties'
    ]),
    translateInfo (props, key) {
      var i = 0; var content = {}
      content['col' + i++] = key
      console.log(props)
      if (key === 'map') {
        props.map(p => {
          return { lat: p.lat, lng: p.lng }
        }).forEach(function (item) {
          content['col' + i++] = item
        })
      } else {
        props.map(p => p[key]).forEach(function (item) {
          content['col' + i++] = item
        })
      }
      content['_cellVariants'] = { col0: 'warning' }
      return content
    },
    goToProperty (id) {
      // eslint-disable-next-line
      this.setProperty(this.properties.find(p => p.id == id))
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
    display: none;
  }
  thead th:first-child{
    display: none;
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
