<template>
  <div align="center">
    <h3 class="title">{{ property.name }}</h3>
    <b-button @click="editProperty()" variant="primary">Editar</b-button>
    <b-button :disabled="num_props_compare === 3"
      @click="addPropCompare(property)" variant="primary">Comparar</b-button>
    <b-button variant="danger">Denunciar</b-button>
    <b-container>
      <b-row class="justify-content-md-center">
        <b-col>
          <b-card-group deck class="deck-images-prop-info">
            <b-row class="m-0 p-0">
              <b-col class="m-0 p-0" cols="12" lg="6">
                <Images :images="property.images" class="images"/>
              </b-col>
              <b-col class="m-0 p-0" cols="12" lg="6">
                <PropertyInfo
                  :description="property.description"
                  :type="property.type"
                  :typology="property.typology"
                  :area="property.area"
                  :district="property.district"
                  :city="property.city"
                  :address="property.address"
                  :lat="property.lat"
                  :lng="property.lng"
                  :furnished="property.furnished"
                  :totalAccess="property.totalAccess"
                  :availability="property.availability"
                  :rent="property.rent"
                  :sell="property.sell"
                  :rentPrice="property.rentPrice"
                  :sellPrice="property.sellPrice"/>
              </b-col>
            </b-row>
          </b-card-group>

          <Bedroom
            :type="property.type"
            :bedrooms="property.bedrooms"/>

          <PresentTenants
            :type="property.type"
            :females="parseInt(property.females)"
            :males="parseInt(property.males)"
            :smokers="parseInt(property.smokers)"
            :pets="property.pets"
            :petsQuantity="parseInt(property.petsQuantity)"
            :occupations="property.occupations"
            class="present-tenants"/>

          <b-card-group deck>
            <RentInclude :expensesIncluded="property.expensesIncluded"/>
            <DivEquipInclude :equipmentIncluded="property.equipmentIncluded"/>
          </b-card-group>

          <TenantsWanted
            class="tenants-wanted"
            :allowedGenders="property.allowedGenders"
            :allowedMinAge="property.allowedMinAge"
            :allowedMaxAge="property.allowedMaxAge"
            :allowedOccupations="property.allowedOccupations"
            :allowedSmokers="property.allowedSmokers"
            :allowedPets="property.allowedPets"/>

          <b-button class="mb-3" @click="editProperty()" variant="primary">Editar</b-button>
          <b-button class="mb-3" :disabled="num_props_compare === 3"
            @click="addPropCompare(property)" variant="primary">Comparar</b-button>
          <b-button class="mb-3" variant="danger">Denunciar</b-button>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { mapGetters, mapActions, mapState } from 'vuex'
import Bedroom from '@/components/Property/DetailView/Bedroom'
import DivEquipInclude from '@/components/Property/DetailView/DivEquipInclude'
import Images from '@/components/Property/DetailView/Images'
import PresentTenants from '@/components/Property/DetailView/PresentTenants'
import PropertyInfo from '@/components/Property/DetailView/PropertyInfo'
import RentInclude from '@/components/Property/DetailView/RentInclude'
import TenantsWanted from '@/components/Property/DetailView/TenantsWanted'

export default {
  name: 'property',
  components: {
    Bedroom,
    DivEquipInclude,
    Images,
    PresentTenants,
    PropertyInfo,
    RentInclude,
    TenantsWanted
  },
  data: () => ({
  }),
  computed: {
    ...mapState({
      properties: state => state.properties.properties,
      property: state => state.properties.property
    }),
    ...mapGetters('properties', [ 'num_props_compare' ])
  },
  methods: {
    ...mapActions('properties', [ 'addPropCompare', 'setPropertyEdit' ]),
    editProperty () {
      this.setPropertyEdit(this.property)
      this.$router.push({ name: 'propertyEdit' })
    }
  }
}
</script>

<style scoped>
.title {
  text-align: center;
}
</style>
