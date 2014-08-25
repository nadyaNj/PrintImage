package am.training;

import am.training.dao.GeneralDao;
import am.training.dao.GeneralDaoImpl;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
        super(parameters);
        final RequiredTextField<String> usernameTextField = new RequiredTextField<String>("userName");
        final PasswordTextField passwordTextField = new PasswordTextField("password");

        Form loginForm = new Form("loginForm") {
            @Override
            protected void onSubmit() {
                GeneralDao generalDao = new GeneralDaoImpl();
                generalDao.selectUser(usernameTextField.getInput(), passwordTextField.getInput());

            }
        };


        loginForm.add(usernameTextField);
        loginForm.add(passwordTextField);


        add(loginForm);

    }
}
