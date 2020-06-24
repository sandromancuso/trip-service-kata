package user

type User struct {
}

func NewUser() *User {
	return &User{}
}

func (this *User) Friends() ([]User, error) {
	var friends []User

	return friends, nil
}
