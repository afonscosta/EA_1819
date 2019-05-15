<template>
  <b-card
    border-variant="secondary"
    header="Tipos de inquilinos procurados"
    header-border-variant="secondary"
  >
    <b-form-group id="tenants-wanted-form-group">
      <b-form-group id="genre-form-group" label="Género:">
        <b-form-select
          v-model="selectedGenre"
          :options="optionsGenre"
          @change="updateSelectedGenre"
        ></b-form-select>
      </b-form-group>
      <b-form-group id="minAge-form-group" label="Idade mínima:">
        <b-input
          v-model="allowedMinAge"
          type="number"
          @update="updateAllowedMinAge"
        ></b-input>
      </b-form-group>
      <b-form-group id="maxAge-form-group" label="Idade máxima:">
        <b-input
          v-model="allowedMaxAge"
          type="number"
          @update="updateAllowedMaxAge"
        ></b-input>
      </b-form-group>
      <b-form-group id="ocupation-form-group" label="Ocupação:">
        <b-form-checkbox-group
          id="checkbox-group-1"
          v-model="selectedOcupation"
          :options="optionsOcupation"
          buttons
          @change="updateSelectedOcupation"
        ></b-form-checkbox-group>
      </b-form-group>
      <b-form-group id="smokers-form-group" label="Fumadores:">
        <b-form-checkbox
          id="checkbox-1"
          v-model="allowedSmoker"
          name="checkbox-1"
          @change="updateAllowedSmokers"
        />
      </b-form-group>
      <b-form-group id="pets-form-group" label="Animais de estimação:">
        <b-form-checkbox
          id="checkbox-2"
          v-model="allowedPets"
          name="checkbox-2"
          @change="updateAllowedPets"
        />
      </b-form-group>
    </b-form-group>
  </b-card>
</template>

<script>
export default {
  name: 'TenantsWanted',
  data: () => ({
    selectedGenre: 'undefined',
    allowedMinAge: null,
    allowedMaxAge: null,
    selectedOcupation: [],
    allowedSmoker: false,
    allowedPets: false,
    optionsGenre: [
      { value: 'undefined', text: 'Indiferente' },
      { value: 'female', text: 'Feminino' },
      { value: 'male', text: 'Masculino' }
    ],
    optionsOcupation: [
      { value: 'student', text: 'Estudante' },
      { value: 'studentWorker', text: 'Trabalhador-estudante' },
      { value: 'worker', text: 'Trabalhador' },
      { value: 'retired', text: 'Reformado' },
      { value: 'unemployed', text: 'Desempregado' }
    ]
  }),
  methods: {
    updateSelectedGenre (value) {
      this.$emit('updateSelectedGenre', value)
    },
    updateAllowedMinAge (value) {
      this.$emit('updateAllowedMinAge', value)
    },
    updateAllowedMaxAge (value) {
      this.$emit('updateAllowedMaxAge', value)
    },
    updateSelectedOcupation (checked) {
      this.$emit('updateSelectedOcupation', checked)
    },
    updateAllowedSmokers (checked) {
      this.$emit('updateAllowedSmokers', checked)
    },
    updateAllowedPets (checked) {
      this.$emit('updateAllowedPets', checked)
    }
  }
}
</script>
