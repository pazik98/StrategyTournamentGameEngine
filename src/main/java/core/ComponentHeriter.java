package core;

import core.component.Component;

public class ComponentHeriter extends Component {
    public ComponentHeriter(int id) {
        super(id);
    }

    public void print() {
        System.out.println("it is component!!");
    }

    @Override
    public String toString() {
        return "ComponentHeriter{" +
                "id=" + this.getId() +
                '}';
    }
}
