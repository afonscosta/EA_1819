<template>
  <div>
    <b-container>
      <b-row class="justify-content-md-center" align-v="center" align-h="center" style="height: 500px;">
        <b-col>
          <b-tabs content-class="mt-5" fill>
            <b-tab title="Comprar/Arrendar" active><HomeSearch/></b-tab>
            <b-tab title="Comprar"><HomeSearch/></b-tab>
            <b-tab title="Arrendar"><HomeSearch/></b-tab>
          </b-tabs>
        </b-col>
      </b-row>
    </b-container>
    <HomeCards/>
  </div>
</template>

<script>
import HomeCards from '@/components/HomeCards'
import HomeSearch from '@/components/HomeSearch'

export default {
  name: 'home',
  components: {
    HomeCards,
    HomeSearch
  }
}
</script>
