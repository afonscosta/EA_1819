<template>
  <b-container>
    <div class="title">
      <b-row align-h="center">
        <b-col cols="12" sm="11" md="9">
          <h1>Complaints</h1>
          <b-card @click="handleClick(complaint.id)" class="complaints_spaced" v-for="complaint in complaints" :key="complaint.id" bg-variant="light" :title="complaint.name">
            <b-card-text v-for="(complaint_text, index) in complaint.complaints" :key="index">
              {{complaint_text}}
            </b-card-text>
            <b-row align-h="end">
              <b-col md="4">
                <b-row>
                  <b-col>
                    <b-button class="blockUser" @click.stop="handleBlockUser(complaint.owner)" size="sm" variant="warning">Bloquear anunciante</b-button>
                  </b-col>
                  <b-col>
                    <b-button class="blockProp" @click.stop="handleBlockProp(complaint.id)" size="sm" variant="warning">Bloquear imóvel</b-button>
                  </b-col>
                </b-row>
              </b-col>
            </b-row>
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
      complaints: state => state.complaints.complaints
    })
  },
  methods: {
    ...mapActions('complaints', [
      'getComplaints',
      'blockUser',
      'blockProperty'
    ]),
    ...mapActions('properties', [
      'goToProperty'
    ]),
    handleClick (evt, id) {
      console.log(evt, 'property')
      this.goToProperty(id)
    },
    handleBlockUser (evt, id) {
      console.log(evt, 'blockuser')
      this.blockUser(id)
    },
    handleBlockProp (evt, id) {
      console.log(evt, 'blockProp')
      this.blockProperty(id)
    },
    goToProperty (id) {
      this.getProperty(id)
        .then(() => {
          // this.setProperty(prop)
          this.$router.push({ name: 'propertyView' })
        })
    }
  }
}
</script>

<style>

.complaints_spaced {
  margin-bottom: 3rem;
}

.title {
  text-align: left
}

</style>
