<template>
  <b-container>
    <div class="title">
      <b-row align-h="center">
        <b-col cols="12" sm="11" md="9">
          <h1>Meus anúncios</h1> v-for="property in userProperties" :key="property.id"
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
                <b-card-text>{{ parseType(prop.type) }}</b-card-text>
                <b-card-text v-if="prop.rent && !prop.bedrooms"><strong>Renda:</strong> {{ prop.rentPrice }} €/mês</b-card-text>
                <b-card-text v-if="prop.sell"><strong>Venda:</strong> {{ prop.sellPrice }} €</b-card-text>
                <b-card-text>{{ prop.address }}</b-card-text>
              </b-col>
              <b-col class="google-map" lg="3" cols="12">
                <GoogleMap :disableUI="true"
                  :drag="false" :height="200"
                  :marker="{ lat: prop.lat, lng: prop.lng }"/>
              </b-col>
            </b-row>
          </b-card>
        </b-col>
      </b-row>
    </div>
  </b-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'

export default {
  
  data: () => ({
  }),
  created () {
    this.getUserProperties()
  },
  computed: {
    ...mapState({
      userProperties: state => state.properties.userProperties
    })
  },
  methods: {
    ...mapActions('properties', [
      'getUserProperties',
      'goToProperty',
      'getProperty'
      ]),
    goToProperty (id) {
      this.getProperty(id)
        .then(() => {
          // this.setProperty(prop)
          this.$router.push({ name: 'propertyView' })
        })
    },
    parseType (type) {
      if (type === 'bedrooms') {
        return 'Quartos'
      } else if (type === 'apartment') {
        return 'Apartamento'
      } else if (type === 'villa') {
        return 'Vivenda'
      }
    }
  }
}
</script>

<style scoped>

</style>
