<template>
  <b-card
    border-variant="secondary"
    header="Tipos de inquilinos procurados"
    header-border-variant="secondary"
  >
    <b-row>
      <b-col>
        <p>Género: {{ allowedGenders }}</p>
      </b-col>
      <b-col>
        <p>Idade mínima: {{ allowedMinAge }}</p>
      </b-col>
      <b-col>
        <p>Idade máxima: {{ allowedMaxAge }}</p>
      </b-col>
    </b-row>
    <b-form-group id="tenants-wanted-ocupation-form-group" label="Ocupação:">
      <b-form-checkbox-group
        id="checkbox-group-1"
        v-model="allowedOccupations"
        :options="optionsOccupation"
        buttons
        button-variant="secondary"
        disabled
      ></b-form-checkbox-group>
    </b-form-group>
    <b-row align-h="center">
      <b-col cols="3">
        <b-form-checkbox
          id="checkbox-2"
          v-model="allowedSmokers"
          name="checkbox-2"
          disabled
        >Permitir fumadores</b-form-checkbox>
      </b-col>
      <b-col cols="3">
        <b-form-checkbox
          id="checkbox-3"
          v-model="allowedPets"
          name="checkbox-3"
          disabled
        >Permitir animais de estimação</b-form-checkbox>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  name: 'TenantsWanted',
  props: {
    allowedGenders: {
      type: String
    },
    allowedMinAge: {
      type: Number
    },
    allowedMaxAge: {
      type: Number
    },
    allowedOccupations: {
      type: Array
    },
    allowedSmokers: {
      type: Boolean
    },
    allowedPets: {
      type: Boolean
    }
  },
  data: () => ({
    optionsOccupation: [
      { value: 'student', text: 'Estudante' },
      { value: 'studentWorker', text: 'Trabalhador-estudante' },
      { value: 'worker', text: 'Trabalhador' },
      { value: 'retired', text: 'Reformado' },
      { value: 'unemployed', text: 'Desempregado' }
    ]
  })
}
</script>

<style scope>
#tenants-wanted-ocupation-form-group {
  margin-bottom: 1rem !important;
}
</style>
