<template>
  <b-card
    border-variant="secondary"
    header="Tipos de inquilinos procurados"
    header-border-variant="secondary"
  >
    <b-row>
      <b-col>
        <b-form-group id="genre-form-group" label="Género:">
          <b-form-select
            v-model="genre"
            :options="optionsGenre"
            @change="updateAllowedGenre"
          ></b-form-select>
        </b-form-group>
      </b-col>
      <b-col>
        <b-form-group id="minAge-form-group" label="Idade mínima:">
          <b-input
            v-model="allowedMinAge"
            type="number"
            @update="updateAllowedMinAge"
          ></b-input>
        </b-form-group>
      </b-col>
      <b-col>
        <b-form-group id="maxAge-form-group" label="Idade máxima:">
          <b-input
            v-model="allowedMaxAge"
            type="number"
            @update="updateAllowedMaxAge"
          ></b-input>
        </b-form-group>
      </b-col>
    </b-row>
    <b-form-group id="tenants-wanted-ocupation-form-group" label="Ocupação:">
      <b-form-checkbox-group
        id="checkbox-group-1"
        v-model="ocupation"
        :options="optionsOcupation"
        buttons
        button-variant="secondary"
        @change="updateAllowedOcupations"
      ></b-form-checkbox-group>
    </b-form-group>
    <b-row align-h="center">
      <b-col cols="3">
        <b-form-checkbox
          id="checkbox-2"
          v-model="allowedSmoker"
          name="checkbox-2"
          @change="updateAllowedSmokers"
        >Permitir fumadores</b-form-checkbox>
      </b-col>
      <b-col cols="3">
        <b-form-checkbox
          id="checkbox-3"
          v-model="allowedPets"
          name="checkbox-3"
          @change="updateAllowedPets"
        >Permitir animais de estimação</b-form-checkbox>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  name: 'TenantsWanted',
  props: {
    genreData: {
      required: false,
      type: String
    },
    allowedMinAgeData: {
      required: false,
      type: Number
    },
    allowedMaxAgeData: {
      required: false,
      type: Number
    },
    ocupationData: {
      required: false,
      type: Array
    },
    allowedSmokerData: {
      required: false,
      type: Boolean
    },
    allowedPetsData: {
      required: false,
      type: Boolean
    }
  },
  data: () => ({
    genre: 'undefined',
    allowedMinAge: null,
    allowedMaxAge: null,
    ocupation: [
      'student',
      'studentWorker',
      'worker',
      'retired',
      'unemployed'
    ],
    allowedSmoker: true,
    allowedPets: true,
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
  created () {
    if (this.genreData) {
      this.genre = this.genreData
    }
    if (this.allowedMinAgeData) {
      this.allowedMinAge = this.allowedMinAgeData
    }
    if (this.allowedMaxAgeData) {
      this.allowedMaxAge = this.allowedMaxAgeData
    }
    if (this.ocupationData) {
      this.ocupation = this.ocupationData
    }
    if (this.allowedSmokerData) {
      this.allowedSmoker = this.allowedSmokerData
    }
    if (this.allowedPetsData) {
      this.allowedPets = this.allowedPetsData
    }
  },
  methods: {
    updateAllowedGenre (value) {
      this.$emit('updateAllowedGenre', value)
    },
    updateAllowedMinAge (value) {
      this.$emit('updateAllowedMinAge', value)
    },
    updateAllowedMaxAge (value) {
      this.$emit('updateAllowedMaxAge', value)
    },
    updateAllowedOcupations (checked) {
      this.$emit('updateAllowedOcupations', checked)
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

<style scope>
#tenants-wanted-ocupation-form-group {
  margin-bottom: 1rem !important;
}
</style>
