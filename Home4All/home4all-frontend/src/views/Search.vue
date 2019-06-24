<template>
  <div>
    <SearchBox />
    <b-container class="mt-3">
      <b-row>
        <b-col>
          <b-pagination
            align="center"
            v-model="currentPage"
            :total-rows="rows"
            :per-page="perPage"
            aria-controls="my-table"
          ></b-pagination>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-card
            class="card-prop"
            v-for="(prop, idx) in currentList" :key="idx"
          >
            <b-row>
              <b-col lg="3" cols="12">
                <img :src="prop.images[0]"/>
              </b-col>
              <b-col align="left" lg="6" cols="12">
                <b-card-text>{{ prop.name }}</b-card-text>
                <b-card-text v-if="prop.rent">{{ prop.rentPrice }} €/mês</b-card-text>
                <b-card-text v-if="prop.sell">{{ prop.sellPrice }} €</b-card-text>
                <b-card-text>{{ prop.address }} €</b-card-text>
              </b-col>
              <b-col lg="3" cols="12">
                <GoogleMap :disableUI="true"
                  :drag="false" :height="200"
                  :marker="{ lat: prop.lat, lng: prop.lng }"/>
              </b-col>
            </b-row>
          </b-card>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-pagination
            align="center"
            v-model="currentPage"
            :total-rows="rows"
            :per-page="perPage"
            aria-controls="my-table"
          ></b-pagination>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { mapState } from 'vuex'
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
    currentPage: 1
  }),
  computed: {
    ...mapState({
      properties: state => state.properties.properties
    }),
    currentList () {
      var items = this.properties
      // Return just page of items needed
      return items.slice(
        (this.currentPage - 1) * this.perPage,
        this.currentPage * this.perPage
      )
    },
    rows () {
      return this.properties.length
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
}
</style>
