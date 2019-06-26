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
            <router-link v-if="$store.state.login.sessionID === ''" :to="{ name: 'register' }">Registar</router-link>
          </b-nav-item>
          <b-nav-item>
            <router-link v-if="$store.state.login.sessionID === ''" :to="{ name: 'login' }">Login</router-link>
          </b-nav-item>

          <b-nav-item-dropdown v-if="$store.state.login.sessionID" right>
          <!-- Using 'button-content' slot -->
          <template slot="button-content"><em>{{ $store.state.login.user.name }}</em></template>
          <b-dropdown-item v-if="!$store.state.login.user.isAdmin" :to="{ name: 'profile'} " >Dados perfil</b-dropdown-item>
          <b-dropdown-item v-on:click="logoutButton()" >Terminar sessão</b-dropdown-item>
        </b-nav-item-dropdown>

        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'Navbar',
  data () {
    return {

    }
  },
  computed: {
    ...mapGetters('properties', [ 'num_props_compare' ])
  },
  methods: {
    ...mapActions('login', ['logout']),
    logoutButton () {
      this.logout().then(() => {
        this.$router.push({ name: 'home' })
      })
    }
  }
}
</script>
