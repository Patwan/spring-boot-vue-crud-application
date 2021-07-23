<template>
     <v-data-table
    :headers="headers"
    :items="users">
        <template v-slot:[`item.edit`]="{ item }">
            <v-btn color="success" @click="editItem(item)">Edit</v-btn>
        </template>
            <template v-slot:[`item.delete`]="{ item }">
            <v-btn color="warning" @click="deleteItem(item)">Delete</v-btn>
        </template>
    </v-data-table>
</template>

<script>
export default {
    data () {
      return {
        headers: [
          { text: 'Name', value: 'name' },
          { text: 'Email', value: 'email' },
          { text: 'Password', value: 'password' },
          { text: 'Edit', value: 'edit' },
          { text: 'Delete', value: 'delete' },
        ]
      }
    },
    computed: {
        users(){
            this.$store.state.users.data
        }
    },
    async fetch(){
        this.$store.commit(
            "users/storeData",
            (await this.$axios.get("http://localhost:8080/users")).data
        );
    },
    methods:{
        async deleteItem(id){
            await this.$axios.delete("http://localhost:8080/users/" + id)
            this.$store.commit(
                "users/storeData",
                (await this.$axios.get("http://localhost:8080/users/")).data
            );
        },
        async editItem(id){
            this.$store.commit("users/storeId", user.id);
            this.$store.commit("users/storeName", user.name);
            this.$store.commit("users/storeEmail", user.email);
            this.$store.commit("users/storePassword", user.password);
        }
    }
}
</script>

<style scoped>

</style>