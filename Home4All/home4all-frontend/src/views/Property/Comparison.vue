<template>
  <div>
    <b-modal
      ref="modal-map"
      centered
      size="lg"
      hide-footer title="Localização do imóvel"
    >
      <google-map/>
    </b-modal>

    <ImagesLightbox v-if="lightboxVisible" @lightboxHidden="lightboxVisible = false" :imgs="images"/>

    <b-container class="mt-3">
      <b-row>
        <b-col>
          <b-table bordered striped hover :fields="fields" :items="items">
            <template slot="col1" slot-scope="row">
              <label v-if="row.index != 1 && row.index != 5 && row.index != 6">{{ row.value }}</label>
              <div v-if="row.index == 1">
                <ImagesPreview :imgs="row.value" :numImgPreview="numImgPreview" @showLightbox="showLightbox"/>
              </div>
              <b-button variant="primary" v-if="row.index == 5" @click="openMap(row.value)">Localização</b-button>
              <b-button variant="primary" v-if="row.index == 6" @click="goToProperty(row.value)">Ver detalhes</b-button>
            </template>
            <template slot="col2" slot-scope="row">
              <label v-if="row.index != 1 && row.index != 5 && row.index != 6">{{ row.value }}</label>
              <div v-if="row.index == 1">
                <ImagesPreview :imgs="row.value" :numImgPreview="numImgPreview" @showLightbox="showLightbox"/>
              </div>
              <b-button variant="primary" v-if="row.index == 5" @click="openMap(row.value)">Localização</b-button>
              <b-button variant="primary" v-if="row.index == 6" @click="goToProperty(row.value)">Ver detalhes</b-button>
            </template>
            <template slot="col3" slot-scope="row">
              <label v-if="row.index != 1 && row.index != 5 && row.index != 6">{{ row.value }}</label>
              <div v-if="row.index == 1">
                <ImagesPreview :imgs="row.value" :numImgPreview="numImgPreview" @showLightbox="showLightbox"/>
              </div>
              <b-button variant="primary" v-if="row.index == 5" @click="openMap(row.value)">Localização</b-button>
              <b-button variant="primary" v-if="row.index == 6" @click="goToProperty(row.value)">Ver detalhes</b-button>
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
import ImagesLightbox from '@/components/ImagesLightbox'
import ImagesPreview from '@/components/ImagesPreview'

export default {
  name: 'comparison',
  components: {
    GoogleMap,
    ImagesLightbox,
    ImagesPreview
  },
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
      {
        id: 1,
        images: [
          '1.jpg',
          '2.jpg',
          '3.jpg',
          '4.jpg',
          '5.jpg',
          '6.jpg',
          '7.jpg'
        ],
        name: 'nome1',
        tipo: 'tipo1',
        area: 100,
        map: 'map1',
        link: '1'
      },
      { id: 2, images: ['2.jpg', '4.jpg', '6.jpg'], name: 'nome2', tipo: 'tipo2', area: 200, map: 'map2', link: '2' },
      { id: 3, images: ['3.jpg', '5.jpg', '7.jpg'], name: 'nome3', tipo: 'tipo3', area: 300, map: 'map3', link: '3' }
    ],
    images: [],
    lightboxVisible: false,
    numImgPreview: 4
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
      this.setProperty(this.properties.find(p => p.id == id))
      this.$router.push({ name: 'propertyView' })
    },
    openMap (value) {
      this.$refs['modal-map'].show()
    },
    showLightbox (imgs) {
      console.log('showLightbox')
      this.images = []
      imgs.forEach(i => this.images.push(this.getImgUrl(i)))
      this.lightboxVisible = true
    },
    getImgUrl (img) {
      return require('../../assets/' + img)
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
