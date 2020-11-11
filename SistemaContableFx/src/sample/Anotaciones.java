package sample;

public class Anotaciones {

/*/
     select idcuenta,fecha,descripcion,debe,haber,saldo
     from asientos aINNER JOIN cuenta_asiento c ON a.id = c.idasiento
     where id=12;

    update cuentas set tipo ='R-' where id=11;


insert into asientos(fecha,descripcion,idusuario ) values( now(),'Descripcion',1);
insert into cuenta_asiento(idcuenta,idasiento,debe,haber,saldo) values(3,26,400,0,100);
insert into cuenta_asiento(idcuenta,idasiento,debe,haber,saldo) values(4,26,0,400,100);
UPDATE cuentas SET saldo_actual=100 WHERE id=3;
UPDATE cuentas SET saldo_actual=200 WHERE id=4;
insert into cuenta_asiento(idcuenta,idasiento,debe,haber,saldo) values(10,26,400,0,100);
insert into cuenta_asiento(idcuenta,idasiento,debe,haber,saldo) values(11,26,0,400,100);
UPDATE cuentas SET saldo_actual=100 WHERE id=10;
UPDATE cuentas SET saldo_actual=200 WHERE id=11;




Activo
+ Aumenta   Debe
- Disminuye  Haber
Pasivo
+ Suma  Haber
- Resta Debe
Patrimonio
+ Suma  Haber
- Resta Debe
Ingreso
Haber
Egreso
Debe


select idasiento,idcuenta,fecha,descripcion,debe,haber,saldo
from asientos a INNER JOIN cuenta_asiento c ON a.id = c.idasiento
where id=35;

select * from cuentas;
update cuentas set saldo_actual=0 where id=3;
update cuentas set saldo_actual=0 where id=4;
update cuentas set saldo_actual=0 where id=10;
update cuentas set saldo_actual=0 where id=11;





SELECT fecha,descripcion,debe,haber,saldo FROM asientos a INNER JOIN cuenta_asiento ca on(a.id = ca.idasiento) WHERE idcuenta=11;

SELECT fecha,descripcion,debe,haber,saldo
FROM asientos a INNER JOIN cuenta_asiento ca on(a.id=ca.idasiento)

;

select * from cuenta_asiento;



SELECT fecha,descripcion,idcuenta,debe,haber,saldo FROM asientos a INNER JOIN cuenta_asiento ca on(a.id=ca.idasiento)
WHERE id= (select max(id)
           from asientos)
ORDER BY fecha,idasiento;



SELECT nombre,fecha,descripcion,idcuenta,debe,haber,saldo
FROM asientos a INNER JOIN cuenta_asiento ca on(a.id=ca.idasiento)
                INNER JOIN cuentas c on (ca.idcuenta=c.id)
WHERE a.id=(select max(id)
       FROM asientos)
ORDER BY fecha,idasiento;





Stage planillaStage=new Stage();
        FXMLLoader loader= new FXMLLoader();
        AnchorPane root =(AnchorPane)loader.load(getClass().getResource("Menu.fxml").openStream());
        ControllerMenu planillaCajaController=loader.getController();
        planillaCajaController.setNombreUsuarioMenu(getNombreUsuario());
        planillaCajaController.setRolUsuarioMenu(getRolUsuario());
        planillaStage.initModality(Modality.APPLICATION_MODAL);
        planillaStage.setScene(new Scene(root));
        planillaStage.show();




stage.setScene( new Scene( FXMLLoader.load(ControllerMenu.class.getResource("Menu.fxml")) ) );




System.out.println("Este es el ==" +cuenta1.getValue()!= cuenta2.getValue());
            System.out.println("Este es el equals ! " +!cuenta1.getValue().equals(cuenta2.getValue()));
            System.out.println("Esto es --->" );
            System.out.println("Este es el equals comun " +cuenta1.getValue().equals(cuenta2.getValue()));









if(cuenta1.getValue()!= cuenta2.getValue() && cuenta3.getValue()==null ) {
            registrarAsientos();
            System.out.println("Entre en la primera");

        }

        if (cuenta1.getValue()!= cuenta2.getValue() && cuenta1.getValue()!=cuenta3.getValue()  && cuenta2.getValue()!=cuenta3.getValue()
                && cuenta3.getValue()!=null && cuenta4.getValue()==null){
            registrarAsientos();
            System.out.println("Entre en la segunda");
        }
        if ( cuenta1.getValue()!= cuenta2.getValue() && cuenta1.getValue()!=cuenta3.getValue() && cuenta1.getValue()!= cuenta4.getValue()
                && cuenta2.getValue()!=cuenta3.getValue() && cuenta2.getValue()!=cuenta4.getValue()
                && cuenta3.getValue()!=cuenta4.getValue()
        && cuenta5.getValue()==null)
        {
            registrarAsientos();
            System.out.println("Entre en la tercera");

        }
        if ( cuenta1.getValue()!= cuenta2.getValue() && cuenta1.getValue()!=cuenta3.getValue()
                && cuenta1.getValue()!= cuenta4.getValue() && cuenta1.getValue()!= cuenta5.getValue()
                && cuenta2.getValue()!=cuenta4.getValue()  && cuenta2.getValue()!=cuenta3.getValue() && cuenta2.getValue()!=cuenta5.getValue()
                && cuenta3.getValue()!=cuenta5.getValue() && cuenta3.getValue()!=cuenta4.getValue()
                && cuenta5.getValue()!=cuenta4.getValue() && cuenta5.getValue()!=null)
        {
            registrarAsientos();
            System.out.println("Entre en la cuarta");

        }







*/


}



