<template>
  <b-container>
    <div class="title">
      <b-row align-h="center">
        <b-col cols="12" sm="11" md="9">
          <h1>Meus anúncios</h1>
          <b-card
            class="card-prop"
            v-for="prop in userProperties" :key="prop"
            @click="goToProperty(prop.id)"
          >
            <b-row align-v="top">
              <b-col align="left" lg="6" cols="12">
                <b-card-title class="mt-2">{{ prop.name }}</b-card-title>
                <b-card-text>{{ parseType(prop.type) }}</b-card-text>
                <b-card-text>{{ prop.address }}</b-card-text>
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
  name: 'MyProperties',
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
