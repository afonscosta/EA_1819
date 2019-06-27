<template>
  <div class="pets">
    <b-row align-v="end">
      <b-col cols="12" lg="8">
        <label for="input-pet">Tipo de animal de estimação:</label>
        <b-form-input
          id="input-pet"
          v-model="pet"
          placeholder="Insira um animal"
          trim
        ></b-form-input>
      </b-col>
      <b-col cols="12" lg="2" align="right">
        <b-button class="middle-button" variant="primary" @click="addPetType">Adicionar</b-button>
      </b-col>
    </b-row>
    <div class="container-pets">
      <b-button v-for="(pet, idx) in pets" :key="idx"
        class="m-1"
        size="sm" variant="outline-dark"
        @click="deletePetType(idx)">{{ pet }}</b-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Pets',
  props: {
    pets: {
      required: true,
      type: Array
    }
  },
  data: () => ({
    pet: ''
  }),
  methods: {
    addPetType () {
      this.$emit('addPetType', this.pet)
      this.pet = ''
    },
    deletePetType (idx) {
      this.$emit('deletePetType', idx)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.pets-row {
  margin-top: 10rem;
}

.container-pets {
  flex: wrap;
  margin-top: 1rem;
}

.middle-button {
  width: auto;
  margin-top: 1rem;
}

@media (max-width: 576px) {
  .middle-button {
    width: 100%;
    margin-top: 1rem;
  }
}
</style>
