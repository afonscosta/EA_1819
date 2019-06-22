<template>
  <div>
    <b-container>
      <b-row class="justify-content-md-center" align-v="center" align-h="center" style="height: 500px;">
        <b-col>
          <b-tabs content-class="mt-5" fill>
            <b-tab title="Comprar/Arrendar" active><SearchForm/></b-tab>
            <b-tab title="Comprar"><SearchForm/></b-tab>
            <b-tab title="Arrendar"><SearchForm/></b-tab>
          </b-tabs>
        </b-col>
      </b-row>
    </b-container>
    <HomeCards/>
  </div>
</template>

<script>
import HomeCards from '@/components/HomeCards'
import SearchForm from '@/components/SearchForm'

export default {
  name: 'Home',
  components: {
    HomeCards,
    SearchForm
  }
}
</script>
