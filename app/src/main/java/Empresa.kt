
class Empresa(val name: String, val city: String, val zipCode: String, val phone: String, val address: String) {

    override fun toString(): String {
        return "Empresa(name='$name', city='$city', zipCode='$zipCode', phone='$phone', address='$address')"
    }
}