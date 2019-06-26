<template>
  
</template>

<script>
import { mapActions, mapState } from 'vuex'

export default {
  name: 'complaints',
  data: () => ({

  }),
  created () {
    // this.getUsers()
  },
  computed: {
    ...mapState({
      users: state => state.users.users
    })
  },
  methods: {
    
  }
}
</script>

<style>
    
</style>
