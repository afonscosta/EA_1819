<template>
  <div class="search">
    <SearchBox class="mt-3" />
    <b-container class="mt-5">
      <b-row v-if="currentList.length === 0">
        <b-col>
          <h4>Não foram encontrados imóveis para a pesquisa realizada</h4>
        </b-col>
      </b-row>
      <b-row v-if="currentList.length > 0">
        <b-col>
          <b-pagination
            align="fill"
            size="sm"
            v-model="currentPage"
            :total-rows="rows"
            :per-page="perPage"
            @change="operation = []"
          ></b-pagination>
        </b-col>
      </b-row>
      <b-row v-if="currentList.length > 0">
        <b-col>
          <b-card
            class="card-prop"
            v-for="(prop, idx) in currentList" :key="idx"
            @click="goToProperty(prop)"
          >
            <b-row align-v="top">
              <b-col class="container-image" lg="3" cols="12">
                <img :src="prop.images[currentImage[idx]]"/>
                <b-button
                  :disabled="currentImage[idx] === 0"
                  @click.stop="operation = [currentImage, '-', idx]"
                  class="btn-left round" variant="primary">&#8249;</b-button>
                <b-button
                  :disabled="currentImage[idx] === prop.images.length - 1"
                  @click.stop="operation = [currentImage, '+', idx]"
                  class="btn-right round" variant="primary">&#8250;</b-button>
              </b-col>
              <b-col align="left" lg="6" cols="12">
                <b-card-title class="mt-2">{{ prop.name }}</b-card-title>
                <b-card-text v-if="prop.rent && !prop.bedrooms">{{ prop.rentPrice }} €/mês</b-card-text>
                <b-card-text v-if="prop.sell">{{ prop.sellPrice }} €</b-card-text>
                <b-card-text>{{ prop.address }}</b-card-text>
              </b-col>
              <b-col class="p-0" lg="3" cols="12">
                <GoogleMap :disableUI="true"
                  :drag="false" :height="200"
                  :marker="{ lat: prop.lat, lng: prop.lng }"/>
              </b-col>
            </b-row>
          </b-card>
        </b-col>
      </b-row>
      <b-row v-if="currentList.length > 0">
        <b-col>
          <b-pagination
            align="fill"
            size="sm"
            v-model="currentPage"
            :total-rows="rows"
            :per-page="perPage"
            @change="operation = []"
          ></b-pagination>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import SearchBox from '@/components/SearchBox'
import GoogleMap from '@/components/GoogleMap'

export default {
  name: 'Home',
  components: {
    SearchBox,
    GoogleMap
  },
  data: () => ({
    perPage: 5,
    currentPage: 1,
    operation: []
  }),
  computed: {
    ...mapState({
      properties: state => state.properties.properties
    }),
    currentList () {
      var items = this.properties
      return items.slice(
        (this.currentPage - 1) * this.perPage,
        this.currentPage * this.perPage
      )
    },
    currentImage () {
      var images = new Array(this.perPage).fill(0)
      if (this.operation.length > 0) {
        images = this.operation[0]
        var op = this.operation[1]
        var idx = parseInt(this.operation[2])
        if (op === '-') {
          images[idx] -= 1
        } else if (op === '+') {
          images[idx] += 1
        }
      }
      return images
    },
    rows () {
      return this.properties.length
    }
  },
  methods: {
    ...mapActions('properties', [
      'getProperty'
    ]),
    goToProperty (prop) {
      console.log(prop.id)
      this.getProperty(prop.id)
        .then(() => {
          // this.setProperty(prop)
          this.$router.push({ name: 'propertyView' })
        })
    }
  }
}
</script>

<style scoped>
img {
  position: relative;
  float: left;
  width: 200px !important;
  height: 200px !important;
  object-fit: scale-down;
}

.card-prop {
  margin-bottom: 1rem;
  cursor: pointer;
  border-width: 2px;
}

.card-prop:hover {
  background-color: #f8f9fa;
  border-color: #343a40;
}

.container-image {
  position: relative;
  width: 50%;
}

.container-image img {
  width: 100%;
  left: 10%;
  height: auto;
}

.container-image .btn-left {
  position: absolute;
  top: 50%;
  left: 8%;
  height: 100px;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  background-color: transparent;
  border-color: transparent;
  color: black;
  font-size: 16px;
  cursor: pointer;
}

.container-image .btn-right {
  position: absolute;
  top: 50%;
  left: 94%;
  height: 100px;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  background-color: transparent;
  border-color: transparent;
  color: black;
  font-size: 16px;
  cursor: pointer;
}

.container-image .btn:hover {
  background-color: #f8f9fa;
  border-color: #343a40;
  color: black;
}

.container-image .btn-primary:active {
  background-color: #6c757d !important;
  border-color: #343a40 !important;
  color: black !important;
}

.container-image .btn-primary:focus {
  background-color: #f8f9fa;
  border-color: #343a40;
  color: black;
  box-shadow: none;
}

.container-image .btn-primary:disabled {
  cursor: default;
  background-color: transparent;
  border-color: transparent;
  color: black;
}
</style>
