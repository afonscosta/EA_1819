<template>
  <b-card
    v-if="selectedType === 'bedrooms'"
    border-variant="secondary"
    header="Arrendatários atuais"
    header-border-variant="secondary"
  >
    <b-form-group
      id="input-group-19"
    >
      <h4><b>Número de pessoas:</b></h4>
      <b-form-group id="input-group-19-1" label="Feminino:">
        <b-input
          v-model="shared.females"
          type="number"
          @change="updateSharedFemales"
        ></b-input>
      </b-form-group>
      <b-form-group id="input-group-19-2" label="Masculino:">
        <b-input
          v-model="shared.males"
          type="number"
          @change="updateSharedMales"
        ></b-input>
      </b-form-group>
      <b-form-group id="input-group-19-3" label="Fumadores:">
        <b-input
          v-model="shared.smokers"
          type="number"
          @change="updateSharedSmokers"
        ></b-input>
      </b-form-group>
      <b-form-group id="input-group-19-4" label="Animais de estimação:">
        <b-input
          v-model="shared.pets"
          type="number"
          @change="updateSharedPets"
        ></b-input>
      </b-form-group>
      <b-form-group id="input-group-19-5" label="Ocupações:">
        <b-form-checkbox-group
          v-model="shared.selectedOcupation"
          :options="optionsOcupation"
          buttons
          @change="updateSharedSelectedOcupation"
        ></b-form-checkbox-group>
      </b-form-group>
    </b-form-group>
  </b-card>
</template>

<script>
export default {
  name: 'PresentTenants',
  props: {
    selectedType: {
      type: String
    }
  },
  data: () => ({
    shared: {
      females: 0,
      males: 0,
      smokers: 0,
      pets: 0,
      totalAccess: false, // Não está no mockup mas está no VPP
      selectedOcupation: []
    },
    optionsOcupation: [
      { value: 'student', text: 'Estudante' },
      { value: 'studentWorker', text: 'Trabalhador-estudante' },
      { value: 'worker', text: 'Trabalhador' },
      { value: 'retired', text: 'Reformado' },
      { value: 'unemployed', text: 'Desempregado' }
    ]
  }),
  methods: {
    updateSharedFemales (value) {
      this.$emit('updateSharedFemales', value)
    },
    updateSharedMales (value) {
      this.$emit('updateSharedMales', value)
    },
    updateSharedSmokers (value) {
      this.$emit('updateSharedSmokers', value)
    },
    updateSharedPets (value) {
      this.$emit('updateSharedPets', value)
    },
    updateSharedSelectedOcupation (checked) {
      this.$emit('updateSharedSelectedOcupation', checked)
    }
  }
}
</script>
