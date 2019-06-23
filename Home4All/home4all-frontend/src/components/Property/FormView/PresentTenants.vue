<template>
  <b-card
    v-if="type === 'bedrooms'"
    border-variant="secondary"
    header="Arrendatários atuais"
    header-border-variant="secondary"
  >
    <b-form-group
      id="present-tenants-form-group"
    >
      <b-row>
        <b-col>
          <b-form-group id="input-group-19-1" label="Feminino:">
            <b-input
              v-model.number="females"
              type="number"
              @change="updateSharedFemales"
            ></b-input>
          </b-form-group>
        </b-col>
        <b-col>
          <b-form-group id="input-group-19-2" label="Masculino:">
            <b-input
              v-model.number="males"
              type="number"
              @change="updateSharedMales"
            ></b-input>
          </b-form-group>
        </b-col>
        <b-col>
          <b-form-group id="input-group-19-3" label="Fumadores:">
            <b-input
              v-model.number="smokers"
              type="number"
              @change="updateSharedSmokers"
            ></b-input>
          </b-form-group>
        </b-col>
        <b-col>
          <b-form-group id="input-group-19-4" label="Animais de estimação:">
            <b-input
              v-model.number="petsQuantity"
              type="number"
              @change="updateSharedPetsQuantity"
            ></b-input>
          </b-form-group>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <Pets :pets="petsData"
            @addPetType="addPetType"
            @deletePetType="deletePetType"
          />
        </b-col>
        <b-col>
          <b-form-group id="present-tenants-ocupation-form-group" label="Ocupações dos arrendatários atuais:">
            <b-form-checkbox-group
              v-model="occupations"
              :options="optionsOccupation"
              buttons
              button-variant="secondary"
              @change="updateSharedOccupation"
            ></b-form-checkbox-group>
          </b-form-group>
        </b-col>
      </b-row>
    </b-form-group>
  </b-card>
</template>

<script>
import Pets from '@/components/Pets'

export default {
  name: 'PresentTenants',
  components: {
    Pets
  },
  props: {
    type: {
      required: true,
      type: String
    },
    femalesData: {
      required: false,
      type: Number
    },
    malesData: {
      required: false,
      type: Number
    },
    smokersData: {
      required: false,
      type: Number
    },
    petsData: {
      required: true,
      default: function () {
        return []
      },
      type: Array
    },
    petsQuantityData: {
      required: false,
      type: Number
    },
    occupationsData: {
      required: false,
      type: Array
    }
  },
  data: () => ({
    females: 0,
    males: 0,
    smokers: 0,
    petsQuantity: 0,
    totalAccess: false, // Não está no mockup mas está no VPP
    occupations: [],
    optionsOccupation: [
      { value: 'student', text: 'Estudante' },
      { value: 'studentWorker', text: 'Trabalhador-estudante' },
      { value: 'worker', text: 'Trabalhador' },
      { value: 'retired', text: 'Reformado' },
      { value: 'unemployed', text: 'Desempregado' }
    ]
  }),
  created () {
    if (this.femalesData) { this.females = this.femalesData }
    if (this.malesData) { this.males = this.malesData }
    if (this.smokersData) { this.smokers = this.smokersData }
    if (this.petsQuantityData) { this.petsQuantity = this.petsQuantityData }
    if (this.occupationsData) { this.occupations = this.occupationsData }
  },
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
    updateSharedPetsQuantity (value) {
      this.$emit('updateSharedPetsQuantity', value)
    },
    updateSharedOccupation (checked) {
      this.$emit('updateSharedOccupation', checked)
    },
    addPetType (pet) {
      this.$emit('addPetType', pet)
    },
    deletePetType (idx) {
      this.$emit('deletePetType', idx)
    }
  }
}
</script>

<style scope>
#present-tenants-ocupation-form-group {
  margin: 0px !important;
}

#present-tenants-form-group {
  margin: 0px !important;
}
</style>
