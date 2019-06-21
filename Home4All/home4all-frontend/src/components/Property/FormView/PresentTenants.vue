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
              v-model.number="shared.females"
              type="number"
              @change="updateSharedFemales"
            ></b-input>
          </b-form-group>
        </b-col>
        <b-col>
          <b-form-group id="input-group-19-2" label="Masculino:">
            <b-input
              v-model.number="shared.males"
              type="number"
              @change="updateSharedMales"
            ></b-input>
          </b-form-group>
        </b-col>
        <b-col>
          <b-form-group id="input-group-19-3" label="Fumadores:">
            <b-input
              v-model.number="shared.smokers"
              type="number"
              @change="updateSharedSmokers"
            ></b-input>
          </b-form-group>
        </b-col>
        <b-col>
          <b-form-group id="input-group-19-4" label="Animais de estimação:">
            <b-input
              v-model.number="shared.petsQuantity"
              type="number"
              @change="updateSharedPets"
            ></b-input>
          </b-form-group>
        </b-col>
      </b-row>
      <b-form-group id="present-tenants-ocupation-form-group" label="Ocupações dos arrendatários atuais:">
        <b-form-checkbox-group
          v-model="shared.ocupation"
          :options="optionsOcupation"
          buttons
          button-variant="secondary"
          @change="updateSharedOcupation"
        ></b-form-checkbox-group>
      </b-form-group>
      <Pets :pets="pets"
        @addPetType="addPetType"
        @deletePetType="deletePetType"
      />
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
    pets: {
      required: true,
      type: Array
    }
  },
  data: () => ({
    shared: {
      females: '0',
      males: '0',
      smokers: '0',
      petsQuantity: '0',
      totalAccess: false, // Não está no mockup mas está no VPP
      ocupation: []
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
    updateSharedOcupation (checked) {
      this.$emit('updateSharedOcupation', checked)
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
