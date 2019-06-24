<template>
  <b-card
    border-variant="secondary"
    header="Tipos de inquilinos procurados"
    header-border-variant="secondary"
    :no-body="!showCard"
  >
    <b-container slot="header">
      <b-row align-v="center">
        <b-col>
          <p class="m-0">Tipos de inquilinos procurados (opcional)</p>
        </b-col>
        <b-col align="right">
          <b-button variant="primary" v-if="!showCard" @click="showCard = !showCard">Mostrar</b-button>
          <b-button variant="primary" v-if="showCard" @click="showCard = !showCard">Esconder</b-button>
        </b-col>
      </b-row>
    </b-container>
    <b-card-body class="p-0" v-if="showCard">
      <b-row>
        <b-col>
          <b-form-group id="gender-form-group" label="Género:">
            <b-form-select
              v-model="allowedGenders"
              :options="optionsGender"
              @change="updateAllowedGenders"
            ></b-form-select>
          </b-form-group>
        </b-col>
        <b-col>
          <b-form-group id="minAge-form-group" label="Idade mínima:">
            <b-input
              v-model.number="allowedMinAge"
              type="number"
              @update="updateAllowedMinAge"
            ></b-input>
          </b-form-group>
        </b-col>
        <b-col>
          <b-form-group id="maxAge-form-group" label="Idade máxima:">
            <b-input
              v-model.number="allowedMaxAge"
              type="number"
              @update="updateAllowedMaxAge"
            ></b-input>
          </b-form-group>
        </b-col>
      </b-row>
      <b-form-group id="tenants-wanted-occupation-form-group" label="Ocupação:">
        <b-form-checkbox-group
          id="checkbox-group-1"
          v-model="allowedOccupations"
          :options="optionsOccupation"
          buttons
          button-variant="secondary"
          @change="updateAllowedOccupations"
        ></b-form-checkbox-group>
      </b-form-group>
      <b-row align-h="center">
        <b-col cols="3">
          <b-form-checkbox
            id="checkbox-2"
            v-model="allowedSmokers"
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
    </b-card-body>
  </b-card>
</template>

<script>
export default {
  name: 'TenantsWanted',
  props: {
    allowedGendersData: {
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
    allowedOccupationsData: {
      required: false,
      type: Array
    },
    allowedSmokersData: {
      required: false,
      type: Boolean
    },
    allowedPetsData: {
      required: false,
      type: Boolean
    }
  },
  data: () => ({
    showCard: false,
    allowedGenders: 'undefined',
    allowedMinAge: null,
    allowedMaxAge: null,
    allowedOccupations: [
      'student',
      'studentWorker',
      'worker',
      'retired',
      'unemployed'
    ],
    allowedSmokers: true,
    allowedPets: true,
    optionsGender: [
      { value: 'undefined', text: 'Indiferente' },
      { value: 'female', text: 'Feminino' },
      { value: 'male', text: 'Masculino' }
    ],
    optionsOccupation: [
      { value: 'student', text: 'Estudante' },
      { value: 'studentWorker', text: 'Trabalhador-estudante' },
      { value: 'worker', text: 'Trabalhador' },
      { value: 'retired', text: 'Reformado' },
      { value: 'unemployed', text: 'Desempregado' }
    ]
  }),
  created () {
    if (this.allowedGendersData) {
      this.allowedGenders = this.allowedGendersData
    }
    if (this.allowedMinAgeData) {
      this.allowedMinAge = this.allowedMinAgeData
    }
    if (this.allowedMaxAgeData) {
      this.allowedMaxAge = this.allowedMaxAgeData
    }
    if (this.allowedOccupationsData) {
      this.allowedOccupations = this.allowedOccupationsData
    }
    if (this.allowedSmokersData) {
      this.allowedSmokers = this.allowedSmokersData
    }
    if (this.allowedPetsData) {
      this.allowedPets = this.allowedPetsData
    }
  },
  methods: {
    updateAllowedGenders (value) {
      this.$emit('updateAllowedGenders', value)
    },
    updateAllowedMinAge (value) {
      this.$emit('updateAllowedMinAge', value)
    },
    updateAllowedMaxAge (value) {
      this.$emit('updateAllowedMaxAge', value)
    },
    updateAllowedOccupations (checked) {
      this.$emit('updateAllowedOccupations', checked)
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
