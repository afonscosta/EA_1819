<template>
  <div class="home">
    <b-container>
      <b-row class="row-search-home" align-v="center" align-h="center">
        <b-col cols="12" md="8">
          <b-tabs fill
            active-nav-item-class="font-weight-bold"
            active-tab-class="font-weight-bold"
          >
            <b-tab title-link-class="'tab-title-class'" title="Comprar/Arrendar" active><SearchForm :rent="true" :sell="true"/></b-tab>
            <b-tab title-link-class="'tab-title-class'" title="Comprar"><SearchForm :rent="false" :sell="true"/></b-tab>
            <b-tab title-link-class="'tab-title-class'" title="Arrendar"><SearchForm :rent="true" :sell="false"/></b-tab>
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

<style scoped>
.home {
  background: url('../assets/7.jpg') no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

.tabs {
  background-color: rgba(248, 249, 250, 0.8);
}

a {
  color: #ff8000;
  font-weight: bold;
}

.row-search-home {
  height: 350px;
}

@media (max-width: 576px) {
  .row-search-home {
    height:100vh;
  }
}
</style>
