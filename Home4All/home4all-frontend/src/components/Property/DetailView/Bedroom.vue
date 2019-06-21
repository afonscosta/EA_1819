<template>
  <b-card
    v-if="type === 'bedrooms'"
    border-variant="secondary"
    header="Quartos disponíveis"
    header-border-variant="secondary"
  >
    <b-row v-for="bedroom in bedrooms" :key="bedroom.id" align-v="end">
      <b-col>
        <label>Tipo: {{ bedroom.type }}</label>
      </b-col>
      <b-col v-if="bedroom.type === 'multiple'">
        <label>Nº de pessoas: {{ bedroom.peopleAmount }}</label>
      </b-col>
      <b-col>
        <label>Área: {{ bedroom.area }}</label>
      </b-col>
      <b-col cols="3">
        <b-row>
          <b-col cols="12">
            <b-form-checkbox
              id="furnished"
              v-model="bedroom.furnished"
              name="checkbox-4"
              disabled
            >Mobilado</b-form-checkbox>
          </b-col>
          <b-col cols="12">
            <b-form-checkbox
              id="privateBathroom"
              v-model="bedroom.privateBathroom"
              name="checkbox-5"
              disabled
            >Casa de banho privativa</b-form-checkbox>
          </b-col>
        </b-row>
      </b-col>
      <b-col>
        <label>Disponibilidade: {{ bedroom.availability }}</label>
      </b-col>
      <b-col>
        <label>Preço: {{ bedroom.rentPrice }}</label>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  name: 'Bedroom',
  props: {
    type: {
      type: String
    },
    bedrooms: {
      type: Array
    }
  }
}
</script>

<style scope>
#bedrooms-form-group {
  margin: 0px !important;
}

#type,
#area,
#furnished,
#privateBathroom,
#availability,
#rentPrice {
  margin: 0px !important;
}
</style>
