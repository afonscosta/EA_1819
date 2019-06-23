<template>
  <div>
    <b-navbar toggleable="sm" type="light" variant="light">
      <b-navbar-brand>
        <router-link :to="{ name: 'home' }">Home4All</router-link>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" style="width: 100%" is-nav>
        <b-navbar-nav class="mx-auto">
          <b-nav-item>
            <router-link :to="{ name: 'search' }">Pesquisar</router-link>
          </b-nav-item>
          <b-nav-item>
            <router-link disable :to="{ name: 'comparison' }">Comparação
              <b-badge v-if="num_props_compare === 1" variant="success">{{ num_props_compare }}</b-badge>
              <b-badge v-if="num_props_compare === 2" variant="warning">{{ num_props_compare }}</b-badge>
              <b-badge v-if="num_props_compare === 3" variant="danger">{{ num_props_compare }}</b-badge>
            </router-link>
          </b-nav-item>
          <b-nav-item>
            <router-link :to="{ name: 'propertyAdd' }">Vender</router-link>
          </b-nav-item>
          <b-nav-item>
            <router-link :to="{ name: 'register' }">Registar</router-link>
          </b-nav-item>
          <b-nav-item>
            <router-link :to="{ name: 'login' }">Login</router-link>
          </b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Navbar',
  computed: {
    ...mapGetters('properties', [ 'num_props_compare' ])
  }
}
</script>
