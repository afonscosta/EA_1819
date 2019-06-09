<template>
  <b-card
    border-variant="secondary"
    header="Tipos de inquilinos procurados"
    header-border-variant="secondary"
  >
    <b-row>
      <b-col>
        <p>Género: {{ genre }}</p>
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
        v-model="ocupation"
        :options="optionsOcupation"
        buttons
        button-variant="secondary"
        disable
      ></b-form-checkbox-group>
    </b-form-group>
    <b-row align-h="center">
      <b-col cols="3">
        <b-form-checkbox
          id="checkbox-2"
          v-model="allowedSmoker"
          name="checkbox-2"
          disable
        >Permitir fumadores</b-form-checkbox>
      </b-col>
      <b-col cols="3">
        <b-form-checkbox
          id="checkbox-3"
          v-model="allowedPets"
          name="checkbox-3"
          disable
        >Permitir animais de estimação</b-form-checkbox>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  name: 'TenantsWanted',
  props: {
    genre: {
      required: true,
      type: String
    },
    allowedMinAge: {
      required: true,
      type: Number
    },
    allowedMaxAge: {
      required: true,
      type: Number
    },
    ocupation: {
      required: true,
      type: Array
    },
    allowedSmoker: {
      required: true,
      type: Boolean
    },
    allowedPets: {
      required: true,
      type: Boolean
    }
  },
  data: () => ({
    optionsOcupation: [
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
