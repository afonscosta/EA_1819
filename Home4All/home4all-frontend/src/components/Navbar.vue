<template>
  <div class="navbar-div">
    <b-navbar toggleable="sm" type="light" variant="light">
      <b-navbar-brand>
        <router-link :to="{ name: 'home' }"><img class="icon" height="42" width="42" src="@/assets/logo.svg"/></router-link>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" style="width: 100%" is-nav>
        <b-navbar-nav class="ml-auto">
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

          <b-nav-item-dropdown v-if="$store.state.login.user" right>
          <!-- Using 'button-content' slot -->
          <template slot="button-content"><em>{{ $store.state.login.user.name }}</em></template>
          <b-dropdown-item :to="{ name: 'profile'} " >Dados perfil</b-dropdown-item>
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

<style scoped>
.icon {
  padding-top: 0.3rem;
  padding-bottom: 0.3rem;
  width: 150px !important;
  height: auto !important;
}

a {
  color: #343a40;
  font-size: 1.3rem;
}

.router-link-active {
  color: #FF8000;
  font-weight: bold;
  font-size: 1.3rem;
}

a:hover {
  color: #994c00;
}

.nav-link {
  margin-left: 1.5rem;
}

.navbar-div {
  border-bottom: 0.5rem solid #FF8000 !important;
}

@media (max-width: 576px) {
  a {
    font-size: 1.3rem;
  }
}
</style>
