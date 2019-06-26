<template>
  <b-container>
    <div class="title">
      <b-row align-h="center">
        <b-col cols="12" sm="11" md="9">
          <h1>Complaints</h1>
          <b-card bg-variant="light" title="Card Title">
            <b-card-text>
              With s
            </b-card-text>
            <b-button variant="primary">Go somewhere</b-button>
          </b-card>
        </b-col>
      </b-row>
    </div>
  </b-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'

export default {
  name: 'complaints',
  data: () => {
    return {}
  },
  created () {
    this.getComplaints()
  },
  computed: {
    ...mapState({
      properties: state => state.complaints.complaints
    })
  },
  methods: {
    ...mapActions('complaints', [
      'getComplaints'
    ])
  }
}
</script>

<style>

.title {
  text-align: left
}

</style>
