<template>
  <div>
    <b-navbar toggleable="sm" type="light" variant="light">
      <b-navbar-brand>
        <router-link to="/">Home4All</router-link>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" style="width: 100%" is-nav>
        <b-navbar-nav class="mx-auto">
          <b-nav-item>
            <router-link to="/search">Pesquisar</router-link>
          </b-nav-item>
          <b-nav-item>
            <router-link disable to="/comparison">Comparação</router-link>
          </b-nav-item>
          <b-nav-item>
            <router-link to="/sell">Vender</router-link>
          </b-nav-item>
          <b-nav-item>
            <router-link to="/register">Registar</router-link>
          </b-nav-item>
          <b-nav-item><router-link to="/login">Login</router-link></b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: 'Navbar'
}
</script>
