function transaccionFromUI(selectedTipoMoneda, selectedTipoTransaccion, selectedUsuario, cantidad, descripcion, username){
	this.usuario = selectedUsuario;
	this.descripcion = descripcion;
	this.fecha = new Date();
	this.tipoTransaccion = selectedTipoTransaccion;
	this.tipoMoneda = selectedTipoMoneda; 
	this.cantidad = cantidad;
	this.owner = username;
}