<template>
  <div>
    <b-row align-v="end" class="mt-3">
      <b-col>
        <label for="input-pet">Tipo de animal de estimação:</label>
        <b-form-input
          id="input-pet"
          v-model="pet"
          placeholder="Insira um animal"
          trim
        ></b-form-input>
      </b-col>
      <b-col>
        <b-button variant="primary" @click="addPetType">Adicionar</b-button>
      </b-col>
    </b-row>
    <b-row v-for="(pet, idx) in petsType" :key="idx">
      <b-col cols="2">
        <p>{{ pet }}</p>
      </b-col>
      <b-col cols="10">
        <b-button size="sm" variant="danger" @click="deletePetType(idx)">Eliminar</b-button>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  name: 'Pets',
  props: {
    petsType: {
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
</style>
